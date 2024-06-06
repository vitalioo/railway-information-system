package com.example.railwayinformationsystem.service;

import com.example.railwayinformationsystem.model.entity.Department;
import com.example.railwayinformationsystem.model.entity.Worker;

import java.util.List;

public interface DepartmentService {
    Department getById(Integer id);

    void deleteById(Integer id);

    void save(Department department);

    List<Department> getAll();

    void update(Department department);

    List<Worker> findAdministrators();

    int countAdministrators();
}
