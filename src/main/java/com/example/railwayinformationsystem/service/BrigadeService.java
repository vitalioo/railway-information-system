package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Brigade;
import com.example.railwayinformationsystem.model.entity.BrigadeType;

import java.util.List;

public interface BrigadeService {
    Brigade getById(Integer id);

    List<BrigadeType> getBrigadeTypes();

    public void deleteById(Integer id);

    void save(Brigade brigade);

    public List<Brigade> getAll();

    void update(Brigade brigade);

}
