package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Cashier;

import java.util.List;

public interface CashierService {
    Cashier getById(Integer id);


    public void deleteById(Integer id);

    void save(Cashier cashier);

    public List<Cashier> getAll();

    void update(Cashier cashier);

}
