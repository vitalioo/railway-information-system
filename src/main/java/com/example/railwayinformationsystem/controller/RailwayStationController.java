package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.RailwayStation;
import com.example.railwayinformationsystem.service.RailwayStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/station")
public class RailwayStationController {
    private final RailwayStationService stationService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        RailwayStation station = stationService.getById(id);
        model.addAttribute("station", station);
        return "station/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("stations", stationService.getAll());
        return "station/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("station", new RailwayStation());
        return "station/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute RailwayStation station, Model model) {
        stationService.save(station);
        model.addAttribute("message", "Station was saved");
        return "redirect:/system/info/station/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        stationService.deleteById(id);
        model.addAttribute("message", "Station was deleted");
        return "redirect:/system/info/station/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        RailwayStation station = stationService.getById(id);
        model.addAttribute("station", station);
        return "station/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute RailwayStation station, Model model) {
        stationService.update(station);
        model.addAttribute("message", "Station was updated");
        return "redirect:/system/info/station/all";
    }

    @GetMapping("/name")
    public String getByName(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("stations", stationService.getAllByName(name));
        return "station/listByName";
    }

    @GetMapping("/count")
    public String getCountByName(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("routes", stationService.getCountAllByName(name));
        return "station/countByName";
    }

    @GetMapping("/all-time")
    public String getByAllTime(@RequestParam(value = "id") Integer id, @RequestParam(value = "arrivalTime") LocalDateTime arrivalTime, @RequestParam(value = "departureTime") LocalDateTime departureTime, Model model) {
        model.addAttribute("routes", stationService.getAllByArrivalTimeAndDepartureTime(id, arrivalTime, departureTime));
        return "station/listByAllTime";
    }

    @GetMapping("/count/all-time")
    public String getCountByAllTime(@RequestParam(value = "id") Integer id, @RequestParam(value = "arrivalTime") LocalDateTime arrivalTime, @RequestParam(value = "departureTime") LocalDateTime departureTime, Model model) {
        model.addAttribute("routes", stationService.getCountAllByArrivalTimeAndDepartureTime(id, arrivalTime, departureTime));
        return "station/countByAllTime";
    }

    @GetMapping("/time")
    public String getByArrivalTime(@RequestParam(value = "id") Integer id, @RequestParam(value = "arrivalTime") LocalDateTime arrivalTime, Model model) {
        model.addAttribute("routes", stationService.getAllByArrivalTime(id, arrivalTime));
        return "station/listByArrivalTime";
    }

    @GetMapping("/count/time")
    public String getCountByArrivalTime(@RequestParam(value = "id") Integer id, @RequestParam(value = "arrivalTime") LocalDateTime arrivalTime, Model model) {
        model.addAttribute("routes", stationService.getCountAllByArrivalTime(id, arrivalTime));
        return "station/countByArrivalTime";
    }

    @GetMapping("/completed")
    public String getCompletedRoutesById(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("routes", stationService.getAllCompletedRoutesById(id));
        return "station/listCompleted";
    }

    @GetMapping("/count/completed")
    public String getCountCompletedRoutesById(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("routes", stationService.getCountAllCompletedRoutesById(id));
        return "station/countCompleted";
    }

    @GetMapping("/queries")
    public String queries(Model model) {
        model.addAttribute("stations", stationService.getAll());
        model.addAttribute("stations", stationService.getAll());
        return "station/queries";
    }
}
