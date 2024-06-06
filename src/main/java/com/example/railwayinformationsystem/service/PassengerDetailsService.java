package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.PassengerDetails;

import java.time.LocalDateTime;
import java.util.List;

public interface PassengerDetailsService {
    PassengerDetails getById(Integer id);

    void deleteById(Integer id);

    void save(PassengerDetails passengerDetails);

    List<PassengerDetails> getAll();

    void update(PassengerDetails passengerDetails);

    List<PassengerDetails> findAllByRoute(String initialDestination, String finalDestination);

    int countAllByRoute(String initialDestination, String finalDestination);

    List<PassengerDetails> findAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime);

    int countAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime);

    List<PassengerDetails> findAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination);

    int countAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination);

    List<PassengerDetails> findAllByGenderAndRoute(String gender, String initialDestination, String finalDestination);

    int countAllByGenderAndRoute(String gender, String initialDestination, String finalDestination);

    List<PassengerDetails> findAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination);

    int countAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination);

}
