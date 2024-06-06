package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.DelayReasonNotFoundException;
import com.example.railwayinformationsystem.model.entity.DelayReason;
import com.example.railwayinformationsystem.repository.DelayReasonRepository;
import com.example.railwayinformationsystem.service.DelayReasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DelayReasonServiceImpl implements DelayReasonService {
    private final DelayReasonRepository delayReasonRepository;
    private final ModelMapper mapper;

    @Override
    public DelayReason getById(Integer id) {
        return delayReasonRepository.findById(id).orElseThrow(() -> new DelayReasonNotFoundException("DelayReason with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        delayReasonRepository.deleteById(id);
        log.debug("DelayReason with id {} deleted", id);
    }

    @Override
    public void save(DelayReason delayReason) {
        delayReasonRepository.save(delayReason);
        log.debug("DelayReason with id {} saved", delayReason.getId());
    }

    @Override
    public List<DelayReason> getAll() {
        return delayReasonRepository.findAll();
    }

    @Override
    public void update(DelayReason delayReason) {
        DelayReason dbDelayReason = getById(delayReason.getId());
        mapper.map(delayReason, dbDelayReason);
        delayReasonRepository.save(dbDelayReason);
        log.debug("DelayReason with id {} updated", delayReason.getId());
    }
}
