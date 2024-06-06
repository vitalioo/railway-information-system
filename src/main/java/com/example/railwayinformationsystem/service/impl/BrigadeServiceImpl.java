package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.BrigadeNotFoundException;
import com.example.railwayinformationsystem.model.entity.Brigade;
import com.example.railwayinformationsystem.model.entity.BrigadeType;
import com.example.railwayinformationsystem.repository.BrigadeRepository;
import com.example.railwayinformationsystem.service.BrigadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrigadeServiceImpl implements BrigadeService {
    private final BrigadeRepository brigadeRepository;
    private final ModelMapper modelMapper;

    @Override
    public Brigade getById(Integer id) {
        return brigadeRepository.findById(id).orElseThrow(() -> new BrigadeNotFoundException("Brigade with id " + id + " not found"));
    }

    @Override
    public List<BrigadeType> getBrigadeTypes() {
        return brigadeRepository.findAllBrigadeTypes();
    }

    @Override
    public void deleteById(Integer id) {
        Brigade brigade = getById(id);
        brigadeRepository.deleteById(id);
        log.debug("Brigade with id {} deleted", brigade.getId());
    }

    @Override
    public void save(Brigade brigade) {
        brigadeRepository.save(brigade);
        log.debug("Brigade with id {} saved", brigade.getId());
    }

    @Override
    public List<Brigade> getAll() {
        List<Brigade> brigades = brigadeRepository.findAll();
        log.debug("{} brigades found", brigades.size());
        return brigades;
    }

    @Override
    public void update(Brigade brigade) {
        Brigade dbBrigade = getById(brigade.getId());
        modelMapper.map(brigade, dbBrigade);
        brigadeRepository.save(dbBrigade);
        log.debug("Brigade with id {} updated", brigade.getId());
    }
}
