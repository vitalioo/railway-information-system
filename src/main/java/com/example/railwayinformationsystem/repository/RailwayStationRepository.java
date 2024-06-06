package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.RailwayStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RailwayStationRepository extends JpaRepository<RailwayStation, Integer> {
    @Query("select rs from RailwayStation rs where rs.name = ?1")
    List<RailwayStation> findAllByName(String name);

    @Query("select count(rs) from RailwayStation rs where rs.name = ?1")
    int countAllByName(String name);

    @Query("select rs from RailwayStation rs where rs.id = ?1 and (rs.arrivalTime <= ?2 or rs.departureTime >= ?3)")
    List<RailwayStation> findAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime);

    @Query("select count(rs) from RailwayStation rs where rs.id = ?1 and (rs.arrivalTime <= ?2 or rs.departureTime >= ?3)")
    int countAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime);

    @Query("select rs from RailwayStation rs where rs.id = ?1 and rs.arrivalTime = ?2")
    List<RailwayStation> findAllByArrivalTime(Integer id, LocalDateTime arrivalTime);

    @Query("select count(rs) from RailwayStation rs where rs.id = ?1 and rs.arrivalTime = ?2")
    int countAllByArrivalTime(Integer id, LocalDateTime arrivalTime);

    @Query("select rs from RailwayStation rs join LocomotiveStation ls on ls.railwayStation.id=rs.id join Locomotive l on l.id=ls.locomotive.id join Schedule s on l.id=s.locomotive.id join Route r on r.id=s.route.id where rs.id = ?1 group by rs.id, l.id order by count(distinct r.id) desc")
    List<RailwayStation> findAllCompletedRoutesById(Integer id);

    @Query("select count(rs) from RailwayStation rs join LocomotiveStation ls on ls.railwayStation.id=rs.id join Locomotive l on l.id=ls.locomotive.id join Schedule s on l.id=s.locomotive.id join Route r on r.id=s.route.id where rs.id = ?1 group by rs.id, l.id order by count(distinct r.id) desc")
    int countAllCompletedRoutesById(Integer id);
}