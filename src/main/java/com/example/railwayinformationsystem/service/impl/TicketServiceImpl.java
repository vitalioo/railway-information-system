package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.TicketNotFoundException;
import com.example.railwayinformationsystem.model.entity.Ticket;
import com.example.railwayinformationsystem.repository.TicketRepository;
import com.example.railwayinformationsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    @Override
    public Ticket getById(Integer id) {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
        log.debug("Ticket with id {} deleted", id);
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
        log.debug("Ticket with id {} saved", ticket.getId());
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        log.debug("{} tickets found", tickets.size());
        return tickets;
    }

    @Override
    public void update(Ticket ticket) {
        Ticket dbTicket = getById(ticket.getId());
        mapper.map(ticket, dbTicket);
        ticketRepository.save(dbTicket);
        log.debug("Ticket with id {} updated", ticket.getId());
    }

    @Override
    public List<Ticket> findAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination) {
        return ticketRepository.findAllBySaleDateAndDestination(startDate, endDate, initialDestination, finalDestination);
    }

    @Override
    public int countAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination) {
        return ticketRepository.countAllBySaleDateAndDestination(startDate, endDate, initialDestination, finalDestination);
    }

    @Override
    public List<Ticket> findAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination) {
        return ticketRepository.findAllByDurationAndDestination(duration, initialDestination, finalDestination);
    }

    @Override
    public int countAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination) {
        return ticketRepository.countAllByDurationAndDestination(duration, initialDestination, finalDestination);
    }

    @Override
    public List<Ticket> findAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination) {
        return ticketRepository.findAllByTicketPriceAndDestination(ticketPrice, initialDestination, finalDestination);
    }

    @Override
    public int countAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination) {
        return ticketRepository.countAllByTicketPriceAndDestination(ticketPrice, initialDestination, finalDestination);
    }

    @Override
    public List<Ticket> findAllUnsoldByDestination(String initialDestination, String finalDestination) {
        return ticketRepository.findAllUnsoldByDestination(initialDestination, finalDestination);
    }

    @Override
    public int countAllUnsoldByDestination(String initialDestination, String finalDestination) {
        return ticketRepository.countAllUnsoldByDestination(initialDestination, finalDestination);
    }
}
