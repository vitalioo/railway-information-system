package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Ticket;
import com.example.railwayinformationsystem.service.PassengerDetailsService;
import com.example.railwayinformationsystem.service.RouteService;
import com.example.railwayinformationsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final PassengerDetailsService passengerDetailsService;
    private final RouteService routeService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("ticket", ticketService.getById(id));
        return "ticket/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("tickets", ticketService.getAll());
        return "ticket/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("routes", routeService.getAll());
        model.addAttribute("passengers", passengerDetailsService.getAll());
        return "ticket/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Ticket ticket, Model model) {
        ticketService.save(ticket);
        model.addAttribute("message", "Ticket was saved");
        return "redirect:/system/info/ticket/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        ticketService.deleteById(id);
        model.addAttribute("message", "Ticket was deleted");
        return "redirect:/system/info/ticket/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("ticket", ticketService.getById(id));
        model.addAttribute("routes", routeService.getAll());
        model.addAttribute("passengers", passengerDetailsService.getAll());
        return "ticket/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Ticket ticket, Model model) {
        ticketService.update(ticket);
        model.addAttribute("message", "Ticket was updated");
        return "redirect:/system/info/ticket/all";
    }

    @GetMapping("/date/destination")
    public String findAllBySaleDateAndDestination(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(name = "initialDestination") String initialDestination,
            @RequestParam(name = "finalDestination") String finalDestination,
            Model model) {
        model.addAttribute("tickets", ticketService.findAllBySaleDateAndDestination(startDate, endDate, initialDestination, finalDestination));
        return "ticket/listBySaleDateAndDestination";
    }

    @GetMapping("/count/date/destination")
    public String countAllBySaleDateAndDestination(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(name = "initialDestination") String initialDestination,
            @RequestParam(name = "finalDestination") String finalDestination,
            Model model) {
        model.addAttribute("count", ticketService.countAllBySaleDateAndDestination(startDate, endDate, initialDestination, finalDestination));
        return "ticket/countBySaleDateAndDestination";
    }

    @GetMapping("/duration/destination")
    public String findAllByDurationAndDestination(@RequestParam BigInteger duration, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("tickets", ticketService.findAllByDurationAndDestination(duration, initialDestination, finalDestination));
        return "ticket/listByDurationAndDestination";
    }

    @GetMapping("/count/duration/destination")
    public String countAllByDurationAndDestination(@RequestParam BigInteger duration, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", ticketService.countAllByDurationAndDestination(duration, initialDestination, finalDestination));
        return "ticket/countByDurationAndDestination";
    }

    @GetMapping("/price/destination")
    public String findAllByTicketPriceAndDestination(@RequestParam Integer price, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("tickets", ticketService.findAllByTicketPriceAndDestination(price, initialDestination, finalDestination));
        return "ticket/listByTicketPriceAndDestination";
    }

    @GetMapping("/count/price/destination")
    public String countAllByTicketPriceAndDestination(@RequestParam Integer price, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", ticketService.countAllByTicketPriceAndDestination(price, initialDestination, finalDestination));
        return "ticket/countByTicketPriceAndDestination";
    }

    @GetMapping("/unsold/destination")
    public String findAllByUnsoldByDestination(@RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("tickets", ticketService.findAllUnsoldByDestination(initialDestination, finalDestination));
        return "ticket/listUnsoldByDestination";
    }

    @GetMapping("/count/unsold/destination")
    public String countAllUnsoldByDestination(@RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", ticketService.countAllUnsoldByDestination(initialDestination, finalDestination));
        return "ticket/countUnsoldByDestination";
    }

    @GetMapping("/queries")
    public String queries(Model model) {
        model.addAttribute("finalDestinations", routeService.getAllFinalDestinations());
        model.addAttribute("initialDestinations", routeService.getAllInitialDestinations());
        return "ticket/queries";
    }
}
