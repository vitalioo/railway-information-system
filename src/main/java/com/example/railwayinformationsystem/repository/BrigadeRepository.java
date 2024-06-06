package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Brigade;
import com.example.railwayinformationsystem.model.entity.BrigadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {
    @Query("select distinct b.type from Brigade b")
    List<BrigadeType> findAllBrigadeTypes();
}