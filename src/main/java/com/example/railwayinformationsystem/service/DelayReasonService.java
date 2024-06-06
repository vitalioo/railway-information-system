package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.DelayReason;

import java.util.List;

public interface DelayReasonService {
    DelayReason getById(Integer id);

    void deleteById(Integer id);

    void save(DelayReason delayReason);

    List<DelayReason> getAll();

    void update(DelayReason delayReason);
}
