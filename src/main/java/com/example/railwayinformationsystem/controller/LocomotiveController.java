package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Locomotive;
import com.example.railwayinformationsystem.service.BrigadeService;
import com.example.railwayinformationsystem.service.LocomotiveService;
import com.example.railwayinformationsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/locomotive")
public class LocomotiveController {
    private final LocomotiveService locomotiveService;
    private final BrigadeService brigadeService;
    private final RouteService routeService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("locomotive", locomotiveService.getById(id));
        model.addAttribute("brigades", brigadeService.getAll());
        return "locomotive/detail";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("locomotives", locomotiveService.getAll());
        return "locomotive/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("locomotive", new Locomotive());
        model.addAttribute("brigades", brigadeService.getAll());
        return "locomotive/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Locomotive locomotive, Model model) {
        locomotiveService.save(locomotive);
        model.addAttribute("message", "Locomotive was saved");
        return "redirect:/system/info/locomotive/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        locomotiveService.deleteById(id);
        model.addAttribute("message", "Locomotive was deleted");
        return "redirect:/system/info/locomotive/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("locomotive", locomotiveService.getById(id));
        model.addAttribute("brigades", brigadeService.getAll());
        return "locomotive/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Locomotive locomotive, Model model) {
        locomotiveService.update(locomotive);
        model.addAttribute("message", "Locomotive was updated");
        return "redirect:/system/info/locomotive/all";
    }

    @GetMapping("/find/route")
    public String findByRoute(@RequestParam String initialDestination, @RequestParam String finalDestination, Model model) {
        model.addAttribute("locomotives", locomotiveService.findAllByRoute(initialDestination, finalDestination));
        return "locomotive/listByRoute";
    }

    @GetMapping("/count/route")
    public String countByRoute(@RequestParam String initialDestination, @RequestParam String finalDestination, Model model) {
        model.addAttribute("count", locomotiveService.countAllByRoute(initialDestination, finalDestination));
        return "locomotive/countByRoute";
    }

    @GetMapping("/find/duration")
    public String findByDuration(@RequestParam BigInteger duration, Model model) {
        model.addAttribute("locomotives", locomotiveService.findAllByDuration(duration));
        return "locomotive/listByDuration";
    }

    @GetMapping("/count/duration")
    public String countByDuration(@RequestParam BigInteger duration, Model model) {
        model.addAttribute("count", locomotiveService.countAllByDuration(duration));
        return "locomotive/countByDuration";
    }

    @GetMapping("/find/ticketPrice")
    public String findByTicketPrice(@RequestParam Integer ticketPrice, Model model) {
        model.addAttribute("locomotives", locomotiveService.findAllByTicketPrice(ticketPrice));
        return "locomotive/listByTicketPrice";
    }

    @GetMapping("/count/ticketPrice")
    public String countByTicketPrice(@RequestParam Integer ticketPrice, Model model) {
        model.addAttribute("count", locomotiveService.countAllByTicketPrice(ticketPrice));
        return "locomotive/countByTicketPrice";
    }

    @GetMapping("/find/ticket-route")
    public String findAllByTicketPriceAndRoute(@RequestParam(name = "ticketPrice") Integer ticketPrice, @RequestParam String initialDestination, @RequestParam String finalDestination, @RequestParam(name = "duration") BigInteger duration, Model model) {
        model.addAttribute("locomotives", locomotiveService.findAllByTicketPriceAndRoute(ticketPrice, initialDestination, finalDestination, duration));
        return "locomotive/listByTicketPriceAndRoute";
    }

    @GetMapping("/count/ticket-route")
    public String countAllByTicketPriceAndRoute(@RequestParam Integer ticketPrice, @RequestParam String initialDestination, @RequestParam String finalDestination, @RequestParam BigInteger duration, Model model) {
        model.addAttribute("count", locomotiveService.countAllByTicketPriceAndRoute(ticketPrice, initialDestination, finalDestination, duration));
        return "locomotive/countByTicketPriceAndRoute";
    }

    @GetMapping("/find/repairs")
    public String findAllByRepairsCount(@RequestParam Integer repairsCount, Model model) {
        model.addAttribute("locomotives", locomotiveService.findAllByRepairsCount(repairsCount));
        return "locomotive/listByRepairsCount";
    }

    @GetMapping("/count/repairs")
    public String countAllByRepairsCount(@RequestParam Integer repairsCount, Model model) {
        model.addAttribute("count", locomotiveService.countAllByRepairsCount(repairsCount));
        return "locomotive/countByRepairsCount";
    }

    @GetMapping("/queries")
    public String queries(Model model) {
        model.addAttribute("initialDestinations", routeService.findAllByInitialDestination());
        model.addAttribute("finalDestinations", routeService.findAllByFinalDestination());
        return "locomotive/queries";
    }
}
