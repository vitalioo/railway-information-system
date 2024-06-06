package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository extends JpaRepository<Cashier, Integer> {
}