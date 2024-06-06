package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Locomotive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface LocomotiveRepository extends JpaRepository<Locomotive, Integer> {
//    @Query("select l from Locomotive l join Schedule s on s.locomotive.id = l.id join Route r on r.id = s.route.id where r.initialDestination = ?1 and r.finalDestination = ?2")

    @Query("select l from Locomotive l join LocomotiveStation ls on ls.locomotive.id = l.id join RouteStation rs on ls.railwayStation.id = rs.station.id join Route r on rs.route.id = r.id where r.initialDestination = ?1 and r.finalDestination = ?2")
    List<Locomotive> findAllByRoute(String initialDestination, String finalDestination);

    @Query("select count(distinct l) from Locomotive l join LocomotiveStation ls on ls.locomotive.id = l.id join RouteStation rs on ls.railwayStation.id = rs.station.id join Route r on rs.route.id = r.id where r.initialDestination = ?1 and r.finalDestination = ?2")
    int countAllByRoute(String initialDestination, String finalDestination);

    @Query("select l from Locomotive l join Schedule s on s.locomotive.id=l.id join Route r on r.id = s.route.id where r.durationSeconds = ?1")
    List<Locomotive> findAllByDuration(BigInteger duration);

    @Query("select count(l) from Locomotive l join Schedule s on s.locomotive.id=l.id join Route r on r.id = s.route.id where r.durationSeconds = ?1")
    int countAllByDuration(BigInteger duration);

    @Query("select l from Locomotive l join Schedule s on s.locomotive.id = l.id join Route r on s.route.id=r.id join Ticket t on t.route.id = r.id where t.ticketPrice = ?1")
    List<Locomotive> findAllByTicketPrice(Integer ticketPrice);

    @Query("select count(l) from Locomotive l join Schedule s on s.locomotive.id = l.id join Route r on s.route.id=r.id join Ticket t on t.route.id = r.id where t.ticketPrice = ?1")
    int countAllByTicketPrice(Integer ticketPrice);

    @Query("select l from Locomotive l join Schedule s on s.locomotive.id = l.id join Route r on s.route.id=r.id join Ticket t on t.route.id = r.id where t.ticketPrice = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3 and r.durationSeconds = ?4")
//    @Query("select s.locomotive from Schedule s join s.route r join s.locomotive l join Ticket t on t.route.id = r.id where t.ticketPrice = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3 and r.durationSeconds = ?4")
    List<Locomotive> findAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration);

    @Query("select count(l) from Locomotive l join Schedule s on s.locomotive.id = l.id join Route r on s.route.id=r.id join Ticket t on t.route.id = r.id where t.ticketPrice = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3 and r.durationSeconds = ?4")
    int countAllByTicketPriceAndRoute(Integer ticketPrice, String initialDestination, String finalDestination, BigInteger duration);

    @Query("select l from Locomotive l join l.maintenances m where m.maintenanceType = 'Ремонт' group by l having count(m) = ?1")
    List<Locomotive> findAllByRepairsCount(Integer repairsCount);

    @Query("select count(l) from Locomotive l join l.maintenances m on m.locomotive.id = l.id where m.maintenanceType = 'Ремонт' group by l.id having count(m) = ?1")
    int countAllByRepairsCount(Integer repairsCount);
}