package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.ScheduleNotFoundException;
import com.example.railwayinformationsystem.model.entity.Schedule;
import com.example.railwayinformationsystem.repository.ScheduleRepository;
import com.example.railwayinformationsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ModelMapper mapper;

    @Override
    public Schedule getById(Integer id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new ScheduleNotFoundException("Schedule with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        scheduleRepository.deleteById(id);
        log.debug("Schedule with id {} deleted", id);
    }

    @Override
    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
        log.debug("Schedule with id {} saved", schedule.getId());
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void update(Schedule schedule) {
        Schedule dbSchedule = getById(schedule.getId());
        mapper.map(schedule, dbSchedule);
        scheduleRepository.save(dbSchedule);
        log.debug("Schedule with id {} updated", schedule.getId());
    }

    @Override
    public int getCountReturnedTicketsByRoute(String initialDestination, String finalDestination) {
        return scheduleRepository.countReturnedTicketsByRoute(initialDestination, finalDestination);
    }
}
