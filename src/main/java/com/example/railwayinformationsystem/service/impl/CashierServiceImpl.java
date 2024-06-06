package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.CashierNotFoundException;
import com.example.railwayinformationsystem.model.entity.Cashier;
import com.example.railwayinformationsystem.repository.CashierRepository;
import com.example.railwayinformationsystem.service.CashierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CashierServiceImpl implements CashierService {
    private final CashierRepository cashierRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cashier getById(Integer id) {
        return cashierRepository.findById(id).orElseThrow(() -> new CashierNotFoundException("Cashier with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        Cashier cashier = getById(id);
        cashierRepository.deleteById(id);
        log.debug("Cashier with id {} deleted", cashier.getId());
    }

    @Override
    public void save(Cashier cashier) {
        cashierRepository.save(cashier);
        log.debug("Cashier with id {} saved", cashier.getId());
    }

    @Override
    public List<Cashier> getAll() {
        List<Cashier> cashiers = cashierRepository.findAll();
        log.debug("{} cashiers found", cashiers.size());
        return cashiers;
    }

    @Override
    public void update(Cashier cashier) {
        Cashier dbCashier = cashierRepository.findById(cashier.getId()).orElseThrow(() -> new CashierNotFoundException("Cashier with id " + cashier.getId() + " not found"));
        modelMapper.map(cashier, dbCashier);
        cashierRepository.save(dbCashier);
        log.debug("Cashier with id {} updated", cashier.getId());
    }
}
