package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Ticket;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    Ticket getById(Integer id);

    void deleteById(Integer id);

    void save(Ticket ticket);

    List<Ticket> getAll();

    void update(Ticket ticket);

    List<Ticket> findAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination);

    int countAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination);

    List<Ticket> findAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination);

    int countAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination);

    List<Ticket> findAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination);

    int countAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination);

    List<Ticket> findAllUnsoldByDestination(String initialDestination, String finalDestination);

    int countAllUnsoldByDestination(String initialDestination, String finalDestination);

}
