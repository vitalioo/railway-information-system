package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    @Query("select m from Maintenance m where m.maintenanceDate between ?1 and ?2")
    List<Maintenance> findAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select count(m) from Maintenance m where m.maintenanceDate between ?1 and ?2")
    int countAllByMaintenanceDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select m from Maintenance m where m.maintenanceDate between ?1 and ?2 and m.maintenanceType = 'Ремонт'")
    List<Maintenance> findAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select count(m) from Maintenance m where m.maintenanceDate between ?1 and ?2 and m.maintenanceType = 'Ремонт'")
    int countAllSentForRepairBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select m from Locomotive l join Maintenance m on l.id = m.locomotive.id where m.maintenanceType = 'Ремонт' group by m.id having count(m) = ?1")
    List<Maintenance> findAllByRepairsCount(Integer repairsCount);

    @Query("select count(m) from Locomotive l join Maintenance m on l.id = m.locomotive.id where m.maintenanceType = 'Ремонт' group by m.id having count(m) = ?1")
    int countAllByRepairsCount(Integer repairsCount);

}