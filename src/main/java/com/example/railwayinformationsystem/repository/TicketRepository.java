package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("select t from Ticket t join t.route r where t.saleDate between ?1 and ?2 and r.initialDestination = ?3 and r.finalDestination = ?4")
    List<Ticket> findAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination);

    @Query("select count(t) from Ticket t join t.route r where t.saleDate between ?1 and ?2 and r.initialDestination = ?3 and r.finalDestination = ?4")
    int countAllBySaleDateAndDestination(LocalDateTime startDate, LocalDateTime endDate, String initialDestination, String finalDestination);

    @Query("select t from Ticket t join t.route r where r.durationSeconds = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    List<Ticket> findAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination);

    @Query("select count(t) from Ticket t join t.route r where r.durationSeconds = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    int countAllByDurationAndDestination(BigInteger duration, String initialDestination, String finalDestination);

    @Query("select t from Ticket t join t.route r where t.ticketPrice = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    List<Ticket> findAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination);

    @Query("select count(t) from Ticket t join t.route r where t.ticketPrice = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    int countAllByTicketPriceAndDestination(Integer ticketPrice, String initialDestination, String finalDestination);

    @Query("select t from Ticket t join t.route r where r.initialDestination = ?1 and r.finalDestination = ?2 and t.saleDate IS NULL")
    List<Ticket> findAllUnsoldByDestination(String initialDestination, String finalDestination);

    @Query("select count(t) from Ticket t join t.route r where r.initialDestination = ?1 and r.finalDestination = ?2 and t.saleDate IS NULL")
    int countAllUnsoldByDestination(String initialDestination, String finalDestination);
}