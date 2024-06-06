package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Worker;

import java.util.List;

public interface WorkerService {
    Worker getById(Integer id);

    void deleteById(Integer id);

    void save(Worker worker);

    List<Worker> getAll();

    void update(Worker worker);

    List<Worker> getAllByRailwayStation(Integer id);

    public int getCountAllByRailwayStation(Integer id);

    public List<Worker> getAllByDepartmentId(Integer id);

    public int getCountAllByDepartmentId(Integer id);

    public List<Worker> getAllByWorkExperience(Short workExperience);

    public int getCountAllByWorkExperience(Short workExperience);

    public List<Worker> getAllByGender(Character gender);

    public int getCountAllByGender(Character gender);

    public List<Worker> getAllByAge(Short age);

    public int getCountAllByAge(Short age);

    public List<Worker> getAllByChildrenCountNotNull();

    public int getCountAllByChildrenCountNotNull();

    public List<Worker> getAllByChildrenCount(Short childrenCount);

    public int getCountAllByChildrenCount(Short childrenCount);

    public List<Worker> getAllBySalary(Integer salary);

    public int getCountAllBySalary(Integer salary);

    public List<Worker> getAllByBrigadeId(Integer id);

    public int getCountAllByBrigadeId(Integer id);

    public List<Worker> getAllInDepartments();

    public int getCountAllInDepartments();

    public List<Worker> getAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId);

    public int getCountAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId);

    public List<Worker> getAllByBrigadeIdAndAge(Integer id, Short age);

    public int getCountAllByBrigadeIdAndAge(Integer id, Short age);

    public int getCountAllSalaryByBrigadeId(Integer id);
}
