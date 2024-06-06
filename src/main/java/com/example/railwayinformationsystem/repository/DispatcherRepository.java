package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Integer> {
}