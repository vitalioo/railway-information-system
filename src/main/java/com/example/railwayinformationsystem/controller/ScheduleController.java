package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.DelayReason;
import com.example.railwayinformationsystem.model.entity.Schedule;
import com.example.railwayinformationsystem.service.DelayReasonService;
import com.example.railwayinformationsystem.service.RouteService;
import com.example.railwayinformationsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/system/info/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final DelayReasonService delayReasonService;
    private final RouteService routeService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("schedule", scheduleService.getById(id));
        return "schedule/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("schedules", scheduleService.getAll());
        return "schedule/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("routes", new ArrayList<DelayReason>());
        return "schedule/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Schedule schedule, Model model) {
        scheduleService.save(schedule);
        model.addAttribute("message", "Schedule was saved");
        return "redirect:/system/info/schedule/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        scheduleService.deleteById(id);
        model.addAttribute("message", "Schedule was deleted");
        return "redirect:/system/info/schedule/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("schedule", scheduleService.getById(id));
        model.addAttribute("allDelayReasons", delayReasonService.getAll());
        return "schedule/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Schedule schedule, Model model) {
        scheduleService.update(schedule);
        model.addAttribute("message", "Schedule was updated");
        return "redirect:/system/info/schedule/all";
    }

    @RequestMapping("/returned-tickets")
    public String getCountReturnedTicketsByRoute(@RequestParam String initialDestination, @RequestParam String finalDestination, Model model) {
        model.addAttribute("count", scheduleService.getCountReturnedTicketsByRoute(initialDestination, finalDestination));
        return "schedule/listReturnedTicketsByRoute";
    }

    @GetMapping("/queries")
    public String queries(Model model) {
        model.addAttribute("finalDestinations", routeService.getAllFinalDestinations());
        model.addAttribute("initialDestinations", routeService.getAllInitialDestinations());
        return "schedule/queries";
    }
}
