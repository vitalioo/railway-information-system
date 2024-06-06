package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.WorkerNotFoundException;
import com.example.railwayinformationsystem.model.entity.Worker;
import com.example.railwayinformationsystem.repository.WorkerRepository;
import com.example.railwayinformationsystem.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final ModelMapper mapper;

    @Override
    public Worker getById(Integer id) {
        return workerRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException("Worker with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        Worker worker = getById(id);
        workerRepository.delete(worker);
        log.debug("Worker with id {} deleted", worker.getId());
    }

    @Override
    public void save(Worker worker) {
        workerRepository.save(worker);
        log.debug("Worker with id {} saved", worker.getId());
    }

    @Override
    public List<Worker> getAll() {
        List<Worker> workers = workerRepository.findAll();
        log.debug("{} workers found", workers.size());
        return workers;
    }

    @Override
    public void update(Worker worker) {
        Worker dbWorker = workerRepository.findById(worker.getId()).orElseThrow(() -> new WorkerNotFoundException("Worker with id " + worker.getId() + " not found"));
        mapper.map(worker, dbWorker);
        workerRepository.save(dbWorker);
        log.debug("Worker with id {} updated", worker.getId());
    }

    @Override
    public List<Worker> getAllByRailwayStation(Integer id) {
        return workerRepository.findAllByRailwayStation(id);
    }

    @Override
    public int getCountAllByRailwayStation(Integer id) {
        return workerRepository.countAllByRailwayStation(id);
    }

    @Override
    public List<Worker> getAllByDepartmentId(Integer id) {
        return workerRepository.findAllByDepartmentId(id);
    }

    @Override
    public int getCountAllByDepartmentId(Integer id) {
        return workerRepository.countAllByDepartmentId(id);
    }

    @Override
    public List<Worker> getAllByWorkExperience(Short workExperience) {
        return workerRepository.findAllByWorkExperience(workExperience);
    }

    @Override
    public int getCountAllByWorkExperience(Short workExperience) {
        return workerRepository.countAllByWorkExperience(workExperience);
    }

    @Override
    public List<Worker> getAllByGender(Character gender) {
        List<Worker> workers = workerRepository.findAllByGender(gender);
        log.debug("Found {} workers with gender {}", workers.size(), gender);
        return workers;
    }

    @Override
    public int getCountAllByGender(Character gender) {
        return workerRepository.countAllByGender(gender);
    }

    @Override
    public List<Worker> getAllByAge(Short age) {
        List<Worker> workers = workerRepository.findAllByAge(age);
        log.debug("Found {} workers with age {}", workers.size(), age);
        return workers;
    }

    @Override
    public int getCountAllByAge(Short age) {
        return workerRepository.countAllByAge(age);
    }

    @Override
    public List<Worker> getAllByChildrenCountNotNull() {
        List<Worker> workers = workerRepository.findAllByChildrenCountNotNull();
        log.debug("Found {} workers with children count not null", workers.size());
        return workers;
    }

    @Override
    public int getCountAllByChildrenCountNotNull() {
        return workerRepository.countAllByChildrenCountNotNull();
    }

    @Override
    public List<Worker> getAllByChildrenCount(Short childrenCount) {
        List<Worker> workers = workerRepository.findAllByChildrenCount(childrenCount);
        log.debug("Found {} workers with children count {}", workers.size(), childrenCount);
        return workers;
    }

    @Override
    public int getCountAllByChildrenCount(Short childrenCount) {
        return workerRepository.countAllByChildrenCount(childrenCount);
    }

    @Override
    public List<Worker> getAllBySalary(Integer salary) {
        List<Worker> workers = workerRepository.findAllBySalary(salary);
        log.debug("Found {} workers with salary {}", workers.size(), salary);
        return workers;
    }

    @Override
    public int getCountAllBySalary(Integer salary) {
        return workerRepository.countAllBySalary(salary);
    }

    @Override
    public List<Worker> getAllByBrigadeId(Integer id) {
        List<Worker> workers = workerRepository.getAllByBrigadeId(id);
        log.debug("Found {} workers with brigade id {}", workers.size(), id);
        return workers;
    }

    @Override
    public int getCountAllByBrigadeId(Integer id) {
        return workerRepository.countAllByBrigadeId(id);
    }

    @Override
    public List<Worker> getAllInDepartments() {
        List<Worker> workers = workerRepository.findAllInDepartments();
        log.debug("Found {} workers in departments", workers.size());
        return workers;
    }

    @Override
    public int getCountAllInDepartments() {
        return workerRepository.countAllInDepartments();
    }

    @Override
    public List<Worker> getAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId) {
        List<Worker> workers = workerRepository.findAllByLocomotiveIdAndBrigadeId(locomotiveId, brigadeId);
        log.debug("Found {} workers with locomotive id {} and brigade id {}", workers.size(), locomotiveId, brigadeId);
        return workers;
    }

    @Override
    public int getCountAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId) {
        return workerRepository.countAllByLocomotiveIdAndBrigadeId(locomotiveId, brigadeId);
    }

    @Override
    public List<Worker> getAllByBrigadeIdAndAge(Integer id, Short age) {
        List<Worker> workers = workerRepository.findAllByBrigadeIdAndAge(id, age);
        log.debug("Found {} workers with brigade id {} and age {}", workers.size(), id, age);
        return workers;
    }

    @Override
    public int getCountAllByBrigadeIdAndAge(Integer id, Short age) {
        return workerRepository.countAllByBrigadeIdAndAge(id, age);
    }

    @Override
    public int getCountAllSalaryByBrigadeId(Integer id) {
        return workerRepository.countAllSalaryByBrigadeId(id);
    }
}
