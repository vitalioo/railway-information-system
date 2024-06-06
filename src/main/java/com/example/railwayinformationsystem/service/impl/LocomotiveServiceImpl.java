package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.LocomotiveNotFoundException;
import com.example.railwayinformationsystem.model.entity.Locomotive;
import com.example.railwayinformationsystem.repository.LocomotiveRepository;
import com.example.railwayinformationsystem.service.LocomotiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocomotiveServiceImpl implements LocomotiveService {
    private final LocomotiveRepository locomotiveRepository;
    private final ModelMapper mapper;

    @Override
    public Locomotive getById(Integer id) {
        return locomotiveRepository.findById(id).orElseThrow(() -> new LocomotiveNotFoundException("Locomotive with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        locomotiveRepository.delete(getById(id));
        log.debug("Locomotive with id {} deleted", id);
    }

    @Override
    public void save(Locomotive locomotive) {
        locomotiveRepository.save(locomotive);
        log.debug("Locomotive with id {} saved", locomotive.getId());
    }

    @Override
    public List<Locomotive> getAll() {
        List<Locomotive> locomotives = locomotiveRepository.findAll();
        log.debug("{} locomotives found", locomotives.size());
        return locomotives;
    }

    @Override
    public void update(Locomotive locomotive) {
        Locomotive dbLocomotive = getById(locomotive.getId());
        mapper.map(locomotive, dbLocomotive);
        locomotiveRepository.save(dbLocomotive);
        log.debug("Locomotive with id {} updated", locomotive.getId());
    }

    @Override
    public List<Locomotive> findAllByRoute(String initialDestination, String finalDestination) {
        return locomotiveRepository.findAllByRoute(initialDestination, finalDestination);
    }

    @Override
    public int countAllByRoute(String initialDestination, String finalDestination) {
        return locomotiveRepository.countAllByRoute(initialDestination, finalDestination);
    }

    @Override
    public List<Locomotive> findAllByDuration(BigInteger duration) {
        return locomotiveRepository.findAllByDuration(duration);
    }

    @Override
    public int countAllByDuration(BigInteger duration) {
        return locomotiveRepository.countAllByDuration(duration);
    }

    @Override
    public List<Locomotive> findAllByTicketPrice(Integer ticketPrice) {
        return locomotiveRepository.findAllByTicketPrice(ticketPrice);
    }

    @Override
    public int countAllByTicketPrice(Integer ticketPrice) {
        return locomotiveRepository.countAllByTicketPrice(ticketPrice);
    }

    @Override
    public List<Locomotive> findAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration) {
        return locomotiveRepository.findAllByTicketPriceAndRoute(ticketPrice, initialDestination, finalDestination, duration);
    }

    @Override
    public int countAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration) {
        return locomotiveRepository.countAllByTicketPriceAndRoute(ticketPrice, initialDestination, finalDestination, duration);
    }

    @Override
    public List<Locomotive> findAllByRepairsCount(Integer repairsCount) {
        return locomotiveRepository.findAllByRepairsCount(repairsCount);
    }

    @Override
    public int countAllByRepairsCount(Integer repairsCount) {
        return locomotiveRepository.countAllByRepairsCount(repairsCount);
    }
}
