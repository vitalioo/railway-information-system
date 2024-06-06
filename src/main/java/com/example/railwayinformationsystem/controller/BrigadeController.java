package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Brigade;
import com.example.railwayinformationsystem.service.BrigadeService;
import com.example.railwayinformationsystem.service.DepartmentService;
import com.example.railwayinformationsystem.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/system/info/brigade")
public class BrigadeController {
    private final BrigadeService brigadeService;
    private final DepartmentService departmentService;
    private final WorkerService workerService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        Brigade brigade = brigadeService.getById(id);
        model.addAttribute("brigade", brigade);
        return "brigade/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Brigade> brigades = brigadeService.getAll();
        model.addAttribute("brigades", brigades);
        return "brigade/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("brigade", new Brigade());
        model.addAttribute("brigadeTypes", brigadeService.getBrigadeTypes());
        model.addAttribute("workers", workerService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        return "brigade/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Brigade brigade, Model model) {
        brigadeService.save(brigade);
        log.debug("Brigade was saved with id = {}", brigade.getId());
        model.addAttribute("message", "Brigade was saved");
        return "redirect:/system/info/brigade/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        brigadeService.deleteById(id);
        model.addAttribute("message", "Brigade was deleted");
        return "redirect:/system/info/brigade/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        Brigade brigade = brigadeService.getById(id);
        model.addAttribute("brigade", brigade);
        model.addAttribute("brigadeTypes", brigadeService.getBrigadeTypes());
        return "brigade/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Brigade brigade, Model model) {
        brigadeService.update(brigade);
        model.addAttribute("message", "Brigade was updated");
        return "redirect:/system/info/brigade/all";
    }
}
