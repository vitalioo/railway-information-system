package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Maintenance;

import java.time.LocalDateTime;
import java.util.List;

public interface MaintenanceService {
    Maintenance getById(Integer id);

    void deleteById(Integer id);

    void save(Maintenance maintenance);

    List<Maintenance> getAll();

    void update(Maintenance maintenance);

    List<Maintenance> getAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    int getCountAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Maintenance> getAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate);

    int getCountAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Maintenance> getAllByRepairCount(Integer repairsCount);

    int getCountAllByRepairCount(Integer repairsCount);

}
