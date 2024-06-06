package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.RailwayStation;

import java.time.LocalDateTime;
import java.util.List;

public interface RailwayStationService {
    RailwayStation getById(Integer id);

    void deleteById(Integer id);

    void save(RailwayStation station);

    List<RailwayStation> getAll();

    void update(RailwayStation station);

    List<RailwayStation> getAllByName(String name);

    int getCountAllByName(String name);

    List<RailwayStation> getAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime);

    int getCountAllByArrivalTimeAndDepartureTime(Integer id, LocalDateTime arrivalTime, LocalDateTime departureTime);

    List<RailwayStation> getAllByArrivalTime(Integer id, LocalDateTime arrivalTime);

    int getCountAllByArrivalTime(Integer id, LocalDateTime arrivalTime);

    List<RailwayStation> getAllCompletedRoutesById(Integer id);

    int getCountAllCompletedRoutesById(Integer id);

}
