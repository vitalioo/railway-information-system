package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.PassengerDetailsNotFoundException;
import com.example.railwayinformationsystem.model.entity.PassengerDetails;
import com.example.railwayinformationsystem.repository.PassengerDetailsRepository;
import com.example.railwayinformationsystem.service.PassengerDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PassengerDetailsServiceImpl implements PassengerDetailsService {
    private final PassengerDetailsRepository passengerDetailsRepository;
    private final ModelMapper mapper;

    @Override
    public PassengerDetails getById(Integer id) {
        return passengerDetailsRepository.findById(id).orElseThrow(() -> new PassengerDetailsNotFoundException("Passenger with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        passengerDetailsRepository.deleteById(id);
        log.debug("Passenger with id {} deleted", id);
    }

    @Override
    public void save(PassengerDetails passengerDetails) {
        passengerDetailsRepository.save(passengerDetails);
        log.debug("Passenger with id {} saved", passengerDetails.getId());
    }

    @Override
    public List<PassengerDetails> getAll() {
        List<PassengerDetails> passengerDetails = passengerDetailsRepository.findAll();
        log.debug("{} passengerDetails found", passengerDetails.size());
        return passengerDetails;
    }

    @Override
    public void update(PassengerDetails passengerDetails) {
        PassengerDetails dbPassengerDetails = passengerDetailsRepository.findById(passengerDetails.getId()).orElseThrow(() -> new PassengerDetailsNotFoundException("Passenger with id " + passengerDetails.getId() + " not found"));
        mapper.map(passengerDetails, dbPassengerDetails);
        passengerDetailsRepository.save(dbPassengerDetails);
        log.debug("Passenger with id {} updated", passengerDetails.getId());
    }

    @Override
    public List<PassengerDetails> findAllByRoute(String initialDestination, String finalDestination) {
        return passengerDetailsRepository.findAllByRoute(initialDestination, finalDestination);
    }

    @Override
    public int countAllByRoute(String initialDestination, String finalDestination) {
        return passengerDetailsRepository.countAllByRoute(initialDestination, finalDestination);
    }

    @Override
    public List<PassengerDetails> findAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime) {
        return passengerDetailsRepository.findAllByDestinationAndDeparture(initialDestination, finalDestination, departureTime);
    }

    @Override
    public int countAllByDestinationAndDeparture(String initialDestination, String finalDestination, LocalDateTime departureTime) {
        return passengerDetailsRepository.countAllByDestinationAndDeparture(initialDestination, finalDestination, departureTime);
    }

    @Override
    public List<PassengerDetails> findAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.findAllByBaggageAndRoute(baggage, initialDestination, finalDestination);
    }

    @Override
    public int countAllByBaggageAndRoute(Boolean baggage, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.countAllByBaggageAndRoute(baggage, initialDestination, finalDestination);
    }

    @Override
    public List<PassengerDetails> findAllByGenderAndRoute(String gender, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.findAllByGenderAndRoute(gender, initialDestination, finalDestination);
    }

    @Override
    public int countAllByGenderAndRoute(String gender, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.countAllByGenderAndRoute(gender, initialDestination, finalDestination);
    }

    @Override
    public List<PassengerDetails> findAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.findAllByAgeAndRoute(age, initialDestination, finalDestination);
    }

    @Override
    public int countAllByAgeAndRoute(Integer age, String initialDestination, String finalDestination) {
        return passengerDetailsRepository.countAllByAgeAndRoute(age, initialDestination, finalDestination);
    }
}
