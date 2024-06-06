package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Locomotive;

import java.math.BigInteger;
import java.util.List;

public interface LocomotiveService {
    public Locomotive getById(Integer id);

    public void deleteById(Integer id);

    public void save(Locomotive locomotive);

    public List<Locomotive> getAll();

    public void update(Locomotive locomotive);

    List<Locomotive> findAllByRoute(String initialDestination, String finalDestination);

    int countAllByRoute(String initialDestination, String finalDestination);

    List<Locomotive> findAllByDuration(BigInteger duration);

    int countAllByDuration(BigInteger duration);

    List<Locomotive> findAllByTicketPrice(Integer ticketPrice);

    int countAllByTicketPrice(Integer ticketPrice);

    List<Locomotive> findAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration);

    int countAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration);

    List<Locomotive> findAllByRepairsCount(Integer repairsCount);

    int countAllByRepairsCount(Integer repairsCount);

}
