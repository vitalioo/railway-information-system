package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.StockRepairman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepairmanRepository extends JpaRepository<StockRepairman, Integer> {
}