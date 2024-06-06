package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Maintenance;
import com.example.railwayinformationsystem.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("maintenance", maintenanceService.getById(id));
        return "maintenance/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("maintenances", maintenanceService.getAll());
        return "maintenance/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("maintenance", new Maintenance());
        return "maintenance/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Maintenance maintenance, Model model) {
        maintenanceService.save(maintenance);
        model.addAttribute("message", "Maintenance was saved");
        return "redirect:/system/info/maintenance/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        maintenanceService.deleteById(id);
        model.addAttribute("message", "Maintenance was deleted");
        return "redirect:/system/info/maintenance/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        Maintenance maintenance = maintenanceService.getById(id);
        model.addAttribute("maintenance", maintenance);
        return "maintenance/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Maintenance maintenance, Model model) {
        maintenanceService.update(maintenance);
        model.addAttribute("message", "Maintenance was updated");
        return "redirect:/system/info/maintenance/all";
    }

    @GetMapping("/date")
    public String getByDateBetween(@RequestParam(value = "startDate") LocalDateTime startDate, @RequestParam(value = "endDate") LocalDateTime endDate, Model model) {
        model.addAttribute("maintenances", maintenanceService.getAllByMaintenanceDateBetween(startDate, endDate));
        return "maintenance/listByDate";
    }

    @GetMapping("/count/date")
    public String getCountByDateBetween(@RequestParam(value = "startDate") LocalDateTime startDate, @RequestParam(value = "endDate") LocalDateTime endDate, Model model) {
        model.addAttribute("count", maintenanceService.getCountAllByMaintenanceDateBetween(startDate, endDate));
        return "maintenance/countByDate";
    }

    @GetMapping("/date/repaired")
    public String getAllSentForRepairByDate(@RequestParam(value = "startDate") LocalDateTime startDate, @RequestParam(value = "endDate") LocalDateTime endDate, Model model) {
        model.addAttribute("maintenances", maintenanceService.getAllSentForRepairBetween(startDate, endDate));
        return "maintenance/listByDateRepaired";
    }

    @GetMapping("/count/date/repaired")
    public String getCountAllSentForRepairByDate(@RequestParam(value = "startDate") LocalDateTime startDate, @RequestParam(value = "endDate") LocalDateTime endDate, Model model) {
        model.addAttribute("count", maintenanceService.getCountAllSentForRepairBetween(startDate, endDate));
        return "maintenance/countByDateRepaired";
    }

    @GetMapping("/repair")
    public String getByRepairCount(@RequestParam(value = "count") Integer count, Model model) {
        model.addAttribute("maintenances", maintenanceService.getAllByRepairCount(count));
        return "maintenance/listByRepairCount";
    }

    @GetMapping("/count/repair")
    public String getCountByRepairCount(@RequestParam(value = "count") Integer count, Model model) {
        model.addAttribute("count", maintenanceService.getCountAllByRepairCount(count));
        return "maintenance/countByRepairCount";
    }

    @GetMapping("/queries")
    public String getQueries(Model model) {
        return "maintenance/queries";
    }
}
