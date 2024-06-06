package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.DelayReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayReasonRepository extends JpaRepository<DelayReason, Integer> {
}
