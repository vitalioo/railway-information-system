package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.RailwayStationNotFoundException;
import com.example.railwayinformationsystem.model.entity.RailwayStation;
import com.example.railwayinformationsystem.repository.RailwayStationRepository;
import com.example.railwayinformationsystem.service.RailwayStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RailwayStationServiceImpl implements RailwayStationService {
    private final RailwayStationRepository stationRepository;
    private final ModelMapper modelMapper;

    @Override
    public RailwayStation getById(Integer id) {
        return stationRepository.findById(id).orElseThrow(() -> new RailwayStationNotFoundException("Station with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        RailwayStation station = getById(id);
        stationRepository.deleteById(id);
        log.debug("Station deleted: {}", station);
    }

    @Override
    public void save(RailwayStation station) {
        stationRepository.save(station);
        log.debug("Station saved: {}", station);
    }

    @Override
    public List<RailwayStation> getAll() {
        List<RailwayStation> stations = stationRepository.findAll();
        log.debug("Get all stations: {}", stations);
        return stations;
    }

    @Override
    public void update(RailwayStation station) {
        RailwayStation dbStation = stationRepository.findById(station.getId()).orElseThrow(() -> new RailwayStationNotFoundException("Station with id " + station.getId() + " not found"));
        modelMapper.map(station, dbStation);
        stationRepository.save(dbStation);
        log.debug("Station updated: {}", station);
    }

    @Override
    public List<RailwayStation> getAllByName(String name) {
        List<RailwayStation> stations = stationRepository.findAllByName(name);
        log.debug("Get all stations: {}", stations);
        return stations;
    }

    @Override
    public int getCountAllByName(String name) {
        return stationRepository.countAllByName(name);
    }

    @Override
    public List<RailwayStation> getAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        List<RailwayStation> stations = stationRepository.findAllByArrivalTimeAndDepartureTime(id, arrivalTime, departureTime);
        log.debug("Get all stations: {}", stations);
        return stations;
    }

    @Override
    public int getCountAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        return stationRepository.countAllByArrivalTimeAndDepartureTime(id, arrivalTime, departureTime);
    }

    @Override
    public List<RailwayStation> getAllByArrivalTime(Integer id, LocalDateTime arrivalTime) {
        List<RailwayStation> stations = stationRepository.findAllByArrivalTime(id, arrivalTime);
        log.debug("Get all stations: {}", stations);
        return stations;
    }

    @Override
    public int getCountAllByArrivalTime(Integer id, LocalDateTime arrivalTime) {
        return stationRepository.countAllByArrivalTime(id, arrivalTime);
    }

    @Override
    public List<RailwayStation> getAllCompletedRoutesById(Integer id) {
        List<RailwayStation> stations = stationRepository.findAllCompletedRoutesById(id);
        log.debug("Get all stations: {}", stations);
        return stations;
    }

    @Override
    public int getCountAllCompletedRoutesById(Integer id) {
        return stationRepository.countAllCompletedRoutesById(id);
    }
}
