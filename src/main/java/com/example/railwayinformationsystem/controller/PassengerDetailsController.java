package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.PassengerDetails;
import com.example.railwayinformationsystem.service.PassengerDetailsService;
import com.example.railwayinformationsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/passenger")
public class PassengerDetailsController {
    private final PassengerDetailsService passengerDetailsService;
    private final RouteService routeService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("passenger", passengerDetailsService.getById(id));
        return "passenger/detail";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("passengers", passengerDetailsService.getAll());
        return "passenger/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("passenger", new PassengerDetails());
        return "passenger/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute PassengerDetails passenger, Model model) {
        passengerDetailsService.save(passenger);
        model.addAttribute("message", "Passenger was saved");
        return "redirect:/system/info/passenger/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        passengerDetailsService.deleteById(id);
        model.addAttribute("message", "Passenger was deleted");
        return "redirect:/system/info/passenger/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("passenger", passengerDetailsService.getById(id));
        return "passenger/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute PassengerDetails passenger, Model model) {
        passengerDetailsService.update(passenger);
        model.addAttribute("message", "Passenger was updated");
        return "redirect:/system/info/passenger/all";
    }

    @GetMapping("/route")
    public String findAllByRoute(@RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("passengers", passengerDetailsService.findAllByRoute(initialDestination, finalDestination));
        return "passenger/listByRoute";
    }

    @GetMapping("/count/route")
    public String countAllByRoute(@RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", passengerDetailsService.countAllByRoute(initialDestination, finalDestination));
        return "passenger/countByRoute";
    }

    @GetMapping("/destination/time")
    public String findAllByDestinationAndDeparture(@RequestParam String initialDestination, @RequestParam String finalDestination, @RequestParam(name = "departureTime") LocalDateTime departureTime, Model model) {
        model.addAttribute("passengers", passengerDetailsService.findAllByDestinationAndDeparture(initialDestination, finalDestination, departureTime));
        return "passenger/listByDestinationAndDeparture";
    }

    @GetMapping("/count/destination/time")
    public String countAllByDestinationAndDeparture(@RequestParam String initialDestination, @RequestParam String finalDestination, @RequestParam(name = "departureTime") LocalDateTime departureTime, Model model) {
        model.addAttribute("count", passengerDetailsService.countAllByDestinationAndDeparture(initialDestination, finalDestination, departureTime));
        return "passenger/countByDestinationAndDeparture";
    }

    @GetMapping("/baggage/route")
    public String findAllByBaggageAndRoute(@RequestParam Boolean baggage, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("passengers", passengerDetailsService.findAllByBaggageAndRoute(baggage, initialDestination, finalDestination));
        return "passenger/listByBaggageAndRoute";
    }

    @GetMapping("/count/baggage/route")
    public String countAllByBaggageAndRoute(@RequestParam Boolean baggage, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", passengerDetailsService.countAllByBaggageAndRoute(baggage, initialDestination, finalDestination));
        return "passenger/countByBaggageAndRoute";
    }

    @GetMapping("/gender/route")
    public String findAllByGenderAndRoute(@RequestParam String gender, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("passengers", passengerDetailsService.findAllByGenderAndRoute(gender, initialDestination, finalDestination));
        return "passenger/listByGenderAndRoute";
    }

    @GetMapping("/count/gender/route")
    public String countAllByGenderAndRoute(@RequestParam String gender, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", passengerDetailsService.countAllByGenderAndRoute(gender, initialDestination, finalDestination));
        return "passenger/countByGenderAndRoute";
    }

    @GetMapping("/age/route")
    public String findAllByAgeAndRoute(@RequestParam Integer age, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("passengers", passengerDetailsService.findAllByAgeAndRoute(age, initialDestination, finalDestination));
        return "passenger/listByAgeAndRoute";
    }

    @GetMapping("/count/age/route")
    public String countAllByAgeAndRoute(@RequestParam Integer age, @RequestParam(name = "initialDestination") String initialDestination, @RequestParam(name = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", passengerDetailsService.countAllByAgeAndRoute(age, initialDestination, finalDestination));
        return "passenger/countByAgeAndRoute";
    }

    @GetMapping("/queries")
    public String getQueries(Model model) {
        model.addAttribute("finalDestinations", routeService.getAllFinalDestinations());
        model.addAttribute("initialDestinations", routeService.getAllInitialDestinations());
        return "passenger/queries";
    }
}
