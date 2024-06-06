package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    @Query("select w from Worker w join w.brigade b join Locomotive l on l.brigade.id = b.id join LocomotiveStation ls on ls.locomotive.id = l.id where ls.railwayStation.id = ?1")
    List<Worker> findAllByRailwayStation(Integer id);

    @Query("select count(distinct w) from Worker w join w.brigade b join Locomotive l on l.brigade.id = b.id join LocomotiveStation ls on ls.locomotive.id = l.id where ls.railwayStation.id = ?1")
    int countAllByRailwayStation(Integer id);

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id join Department d on b.department.id = d.id where d.id = ?1")
    List<Worker> findAllByDepartmentId(Integer id);

    @Query("select count(w) from Worker w join Brigade b on b.id = w.brigade.id join Department d on b.department.id = d.id where d.id = ?1")
    int countAllByDepartmentId(Integer id);

    @Query("select w from Worker w where w.workExperience = ?1")
    List<Worker> findAllByWorkExperience(Short workExperience);

    @Query("select count(w) from Worker w where w.workExperience = ?1")
    int countAllByWorkExperience(Short workExperience);

    @Query("select w from Worker w where w.gender = ?1")
    List<Worker> findAllByGender(Character gender);

    @Query("select count(w) from Worker w where w.gender = ?1")
    int countAllByGender(Character gender);

    @Query("select w from Worker w where w.age = ?1")
    List<Worker> findAllByAge(Short age);

    @Query("select count(w) from Worker w where w.age = ?1")
    int countAllByAge(Short age);

    @Query("select w from Worker w where w.childrenCount > 0")
    List<Worker> findAllByChildrenCountNotNull();

    @Query("select count(w) from Worker w where w.childrenCount > 0")
    int countAllByChildrenCountNotNull();

    @Query("select w from Worker w where w.childrenCount = ?1")
    List<Worker> findAllByChildrenCount(Short childrenCount);

    @Query("select count(w) from Worker w where w.childrenCount = ?1")
    int countAllByChildrenCount(Short childrenCount);

    @Query("select w from Worker w where w.salary = ?1")
    List<Worker> findAllBySalary(Integer salary);

    @Query("select count(w) from Worker w where w.salary = ?1")
    int countAllBySalary(Integer salary);

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id where b.id = ?1")
    List<Worker> getAllByBrigadeId(Integer id);

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id where b.id = ?1")
    int countAllByBrigadeId(Integer id);

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id join Department d on b.department.id = d.id")
    List<Worker> findAllInDepartments();

    @Query("select count(w) from Worker w join Brigade b on b.id = w.brigade.id join Department d on b.department.id = d.id")
    int countAllInDepartments();

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id join Locomotive l on l.id = b.id where l.id = ?1 and b.id = ?2")
    List<Worker> findAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId);

    @Query("select count(w) from Worker w join Brigade b on b.id = w.brigade.id join Locomotive l on l.id = b.id where l.id = ?1 and b.id = ?2")
    int countAllByLocomotiveIdAndBrigadeId(Integer locomotiveId, Integer brigadeId);

    @Query("select w from Worker w join Brigade b on b.id = w.brigade.id where b.id = ?1 and w.age = ?2")
    List<Worker> findAllByBrigadeIdAndAge(Integer id, Short age);

    @Query("select count(w) from Worker w join Brigade b on b.id = w.brigade.id where b.id = ?1 and w.age = ?2")
    int countAllByBrigadeIdAndAge(Integer id, Short age);

    @Query("select avg(w.salary) as avg_salary from Brigade b join Worker w on b.id = w.brigade.id where b.id = ?1 group by b.id")
    int countAllSalaryByBrigadeId(Integer id);
}