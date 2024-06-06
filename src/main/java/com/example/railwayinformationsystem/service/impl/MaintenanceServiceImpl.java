package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.MaintenanceNotFoundException;
import com.example.railwayinformationsystem.model.entity.Maintenance;
import com.example.railwayinformationsystem.repository.MaintenanceRepository;
import com.example.railwayinformationsystem.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    private final ModelMapper mapper;

    @Override
    public Maintenance getById(Integer id) {
        return maintenanceRepository.findById(id).orElseThrow(() -> new MaintenanceNotFoundException("Maintenance not found"));
    }

    @Override
    public void deleteById(Integer id) {
        Maintenance maintenance = getById(id);
        maintenanceRepository.deleteById(id);
        log.debug("Maintenance deleted: {}", maintenance);
    }

    @Override
    public void save(Maintenance maintenance) {
        maintenanceRepository.save(maintenance);
        log.debug("Maintenance saved: {}", maintenance);
    }

    @Override
    public List<Maintenance> getAll() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        log.debug("Found {} maintenances", maintenances.size());
        return maintenances;
    }

    @Override
    public void update(Maintenance maintenance) {
        Maintenance dbMaintenance = maintenanceRepository.findById(maintenance.getId()).orElseThrow(() -> new MaintenanceNotFoundException("Maintenance not found"));
        mapper.map(maintenance, dbMaintenance);
        maintenanceRepository.save(dbMaintenance);
        log.debug("Maintenance updated: {}", maintenance);
    }

    @Override
    public List<Maintenance> getAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<Maintenance> maintenances = maintenanceRepository.findAllByMaintenanceDateBetween(startDate, endDate);
        log.debug("Found {} maintenances between {} and {}", maintenances.size(), startDate, endDate);
        return maintenances;
    }

    @Override
    public int getCountAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return maintenanceRepository.countAllByMaintenanceDateBetween(startDate, endDate);
    }

    @Override
    public List<Maintenance> getAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<Maintenance> maintenances = maintenanceRepository.findAllSentForRepairBetween(startDate, endDate);
        log.debug("Found {} maintenances between {} and {}", maintenances.size(), startDate, endDate);
        return maintenances;
    }

    @Override
    public int getCountAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return maintenanceRepository.countAllSentForRepairBetween(startDate, endDate);
    }

    @Override
    public List<Maintenance> getAllByRepairCount(Integer repairsCount) {
        List<Maintenance> maintenances = maintenanceRepository.findAllByRepairsCount(repairsCount);
        log.debug("Found {} maintenances with {} repairs", maintenances.size(), repairsCount);
        return maintenances;
    }

    @Override
    public int getCountAllByRepairCount(Integer repairsCount) {
        return maintenanceRepository.countAllByRepairsCount(repairsCount);
    }
}
