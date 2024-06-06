package com.example.railwayinformationsystem.service.impl;

import com.example.railwayinformationsystem.exception.DepartmentNotFoundException;
import com.example.railwayinformationsystem.model.entity.Department;
import com.example.railwayinformationsystem.model.entity.Worker;
import com.example.railwayinformationsystem.repository.DepartmentRepository;
import com.example.railwayinformationsystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;

    @Override
    public Department getById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found"));
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.delete(getById(id));
        log.debug("Department with id {} deleted", id);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
        log.debug("Department with id {} saved", department.getId());
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = departmentRepository.findAll();
        log.debug("{} departments found", departments.size());
        return departments;
    }

    @Override
    public void update(Department department) {
        Department dbDepartment = getById(department.getId());
        mapper.map(department, dbDepartment);
        departmentRepository.save(dbDepartment);
        log.debug("Department with id {} updated", department.getId());
    }

    @Override
    public List<Worker> findAdministrators() {
        return departmentRepository.findAdministrators();
    }

    @Override
    public int countAdministrators() {
        return departmentRepository.countAdministrators();
    }
}
