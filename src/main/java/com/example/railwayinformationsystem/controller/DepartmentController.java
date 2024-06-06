package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Department;
import com.example.railwayinformationsystem.service.DepartmentService;
import com.example.railwayinformationsystem.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final WorkerService workerService;

    @RequestMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("department", departmentService.getById(id));
        return "department/detail";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        return "department/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("workers", workerService.getAll());
        return "department/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Department department, Model model) {
        departmentService.save(department);
        model.addAttribute("message", "Department was saved");
        return "redirect:/system/info/department/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        departmentService.deleteById(id);
        model.addAttribute("message", "Department was deleted");
        return "redirect:/system/info/department/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("department", departmentService.getById(id));
        model.addAttribute("workers", workerService.getAll());
        return "department/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Department department, Model model) {
        departmentService.update(department);
        model.addAttribute("message", "Department was updated");
        return "redirect:/system/info/department/all";
    }

    @GetMapping("/administrators")
    public String findAdministrators(Model model) {
        model.addAttribute("administrators", departmentService.findAdministrators());
        return "department/administrators";
    }

    @GetMapping("/count")
    public String countAdministrators(Model model) {
        model.addAttribute("count", departmentService.countAdministrators());
        return "department/count";
    }

    @GetMapping("/queries")
    public String queries() {
        return "department/queries";
    }
}
