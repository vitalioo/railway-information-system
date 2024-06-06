package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Worker;
import com.example.railwayinformationsystem.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/system/info/worker")
public class WorkerController {
    private final WorkerService workerService;
    private final BrigadeService brigadeService;
    private final DepartmentService departmentService;
    private final RailwayStationService railwayStationService;
    private final LocomotiveService locomotiveService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("worker", workerService.getById(id));
        return "worker/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("workers", workerService.getAll());
        return "worker/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("worker", new Worker());
        model.addAttribute("brigades", brigadeService.getAll());
        return "worker/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Worker worker, Model model) {
        workerService.save(worker);
        model.addAttribute("message", "Worker was saved");
        return "redirect:/system/info/worker/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        workerService.deleteById(id);
        model.addAttribute("message", "Worker was deleted");
        return "redirect:/system/info/worker/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("worker", workerService.getById(id));
        return "worker/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Worker worker, Model model) {
        workerService.update(worker);
        model.addAttribute("message", "Worker was updated");
        return "redirect:/system/info/worker/all";
    }

    @GetMapping("/station")
    public String getByRailwayStation(@RequestParam(value = "id") Integer id, Model model) {
        List<Worker> workers = workerService.getAllByRailwayStation(id);
        model.addAttribute("workers", workers);
        return "worker/listByStation";
    }

    @GetMapping("/count/station")
    public String getCountByRailwayStation(@RequestParam(value = "id") Integer id, Model model) {
        int count = workerService.getCountAllByRailwayStation(id);
        model.addAttribute("count", count);
        return "worker/countByStation";
    }

    @GetMapping("/department/id")
    public String getByDepartmentId(@RequestParam(value = "id") Integer id, Model model) {
        List<Worker> workers = workerService.getAllByDepartmentId(id);
        model.addAttribute("workers", workers);
        return "worker/listByDepartment";
    }

    @GetMapping("/count/department/id")
    public String getCountByDepartmentId(@RequestParam(value = "id") Integer id, Model model) {
        int count = workerService.getCountAllByDepartmentId(id);
        model.addAttribute("count", count);
        return "worker/countByDepartment";
    }

    @GetMapping("/experience")
    public String getByWorkExperience(@RequestParam(value = "experience") Short experience, Model model) {
        List<Worker> workers = workerService.getAllByWorkExperience(experience);
        model.addAttribute("workers", workers);
        return "worker/listByExperience";
    }

    @GetMapping("/count/experience")
    public String getCountByWorkExperience(@RequestParam(value = "experience") Short experience, Model model) {
        int count = workerService.getCountAllByWorkExperience(experience);
        model.addAttribute("count", count);
        return "worker/countByExperience";
    }

    @GetMapping("/gender")
    public String getByGender(@RequestParam(value = "gender") Character gender, Model model) {
        List<Worker> workers = workerService.getAllByGender(gender);
        model.addAttribute("workers", workers);
        return "worker/listByGender";
    }

    @GetMapping("/count/gender")
    public String getCountByGender(@RequestParam(value = "gender") Character gender, Model model) {
        int count = workerService.getCountAllByGender(gender);
        model.addAttribute("count", count);
        return "worker/countByGender";
    }

    @GetMapping("/age")
    public String getByAge(@RequestParam(value = "age") Short age, Model model) {
        List<Worker> workers = workerService.getAllByAge(age);
        model.addAttribute("workers", workers);
        return "worker/listByAge";
    }

    @GetMapping("/count/age")
    public String getCountByAge(@RequestParam(value = "age") Short age, Model model) {
        int count = workerService.getCountAllByAge(age);
        model.addAttribute("count", count);
        return "worker/countByAge";
    }

    @GetMapping("/children")
    public String getByChildrenCountNotNull(Model model) {
        List<Worker> workers = workerService.getAllByChildrenCountNotNull();
        model.addAttribute("workers", workers);
        return "worker/notNullListByChildren";
    }

    @GetMapping("/count/children")
    public String getCountByChildrenCountNotNull(Model model) {
        int count = workerService.getCountAllByChildrenCountNotNull();
        model.addAttribute("count", count);
        return "worker/notNullCountByChildren";
    }

    @GetMapping("/children/count")
    public String getByChildrenCount(@RequestParam(value = "children") Short childrenCount, Model model) {
        List<Worker> workers = workerService.getAllByChildrenCount(childrenCount);
        model.addAttribute("workers", workers);
        return "worker/listByChildrenCount";
    }

    @GetMapping("/count/children/count")
    public String getCountByChildrenCount(@RequestParam(value = "children") Short childrenCount, Model model) {
        int count = workerService.getCountAllByChildrenCount(childrenCount);
        model.addAttribute("count", count);
        return "worker/countByChildrenCount";
    }

    @GetMapping("/salary")
    public String getBySalary(@RequestParam(value = "salary") Integer salary, Model model) {
        List<Worker> workers = workerService.getAllBySalary(salary);
        model.addAttribute("workers", workers);
        return "worker/listBySalary";
    }

    @GetMapping("/count/salary")
    public String getCountBySalary(@RequestParam(value = "salary") Integer salary, Model model) {
        int count = workerService.getCountAllBySalary(salary);
        model.addAttribute("count", count);
        return "worker/countBySalary";
    }

    @GetMapping("/brigade")
    public String getByBrigadeId(@RequestParam(value = "id") Integer id, Model model) {
        List<Worker> workers = workerService.getAllByBrigadeId(id);
        model.addAttribute("workers", workers);
        return "worker/listByBrigade";
    }

    @GetMapping("/count/brigade")
    public String getCountByBrigadeId(@RequestParam(value = "id") Integer id, Model model) {
        int count = workerService.getCountAllByBrigadeId(id);
        model.addAttribute("count", count);
        return "worker/countByBrigade";
    }

    @GetMapping("/department")
    public String getInDepartments(Model model) {
        List<Worker> workers = workerService.getAllInDepartments();
        model.addAttribute("workers", workers);
        return "worker/listInDepartments";
    }

    @GetMapping("/count/department")
    public String getCountInDepartments(Model model) {
        int count = workerService.getCountAllInDepartments();
        model.addAttribute("count", count);
        return "worker/countInDepartments";
    }

    @GetMapping("/brigade/locomotive")
    public String getByBrigadeIdAndLocomotiveId(@RequestParam(value = "id1") Integer brigadeId, @RequestParam(value = "id2") Integer locomotiveId, Model model) {
        List<Worker> workers = workerService.getAllByLocomotiveIdAndBrigadeId(brigadeId, locomotiveId);
        model.addAttribute("workers", workers);
        return "worker/listByBrigadeAndLocomotive";
    }

    @GetMapping("/count/brigade/locomotive")
    public String getCountByBrigadeIdAndLocomotiveId(@RequestParam(value = "id1") Integer brigadeId, @RequestParam(value = "id2") Integer locomotiveId, Model model) {
        int count = workerService.getCountAllByLocomotiveIdAndBrigadeId(brigadeId, locomotiveId);
        model.addAttribute("count", count);
        return "worker/countByBrigadeAndLocomotive";
    }

    @GetMapping("/brigade/age")
    public String getByBrigadeIdAndAge(@RequestParam(value = "id") Integer brigadeId, @RequestParam(value = "age") Short age, Model model) {
        List<Worker> workers = workerService.getAllByBrigadeIdAndAge(brigadeId, age);
        model.addAttribute("workers", workers);
        return "worker/listByBrigadeAndAge";
    }

    @GetMapping("/count/brigade/age")
    public String getCountByBrigadeIdAndAge(@RequestParam(value = "id") Integer brigadeId, @RequestParam(value = "age") Short age, Model model) {
        int count = workerService.getCountAllByBrigadeIdAndAge(brigadeId, age);
        model.addAttribute("count", count);
        return "worker/countByBrigadeAndAge";
    }

    @GetMapping("/brigade/salary")
    public String getAllSalaryByBrigadeId(@RequestParam(value = "id") Integer brigadeId, Model model) {
        int count = workerService.getCountAllSalaryByBrigadeId(brigadeId);
        model.addAttribute("count", count);
        return "worker/countByBrigadeAndSalary";
    }

    @GetMapping("/queries")
    public String getQueries(Model model) {
        model.addAttribute("stations", railwayStationService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("brigades", brigadeService.getAll());
        model.addAttribute("locomotives", locomotiveService.getAll());
        return "worker/queries";
    }
}
