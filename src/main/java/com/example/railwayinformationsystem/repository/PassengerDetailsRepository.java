package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Integer> {
    @Query("select p from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where r.initialDestination = ?1 and r.finalDestination = ?2")
    List<PassengerDetails> findAllByRoute(String initialDestination, String finalDestination);

    @Query("select count(distinct p) from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where r.initialDestination = ?1 and r.finalDestination = ?2")
    int countAllByRoute(String initialDestination, String finalDestination);

    @Query("select p from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id join RouteStation rs on r.id = rs.route.id join RailwayStation station on rs.station.id = station.id where r.initialDestination = ?1 and r.finalDestination = ?2 and station.departureTime = ?3")
    List<PassengerDetails> findAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime);

    @Query("select count(distinct p) from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id join RouteStation rs on r.id = rs.route.id join RailwayStation station on rs.station.id = station.id where r.initialDestination = ?1 and r.finalDestination = ?2 and station.departureTime = ?3")
    int countAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime);

    @Query("select p from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.baggage = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    List<PassengerDetails> findAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination);

    @Query("select count(distinct p) from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.baggage = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    int countAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination);

    @Query("select p from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.gender = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    List<PassengerDetails> findAllByGenderAndRoute(String gender, String initialDestination, String finalDestination);

    @Query("select count(distinct p) from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.gender = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    int countAllByGenderAndRoute(String gender, String initialDestination, String finalDestination);

    @Query("select p from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.age = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    List<PassengerDetails> findAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination);

    @Query("select count(distinct p) from PassengerDetails p join Ticket t on p.id = t.passenger.id join Route r on t.route.id = r.id where p.age = ?1 and r.initialDestination = ?2 and r.finalDestination = ?3")
    int countAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination);
}