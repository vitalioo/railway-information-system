package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Route;
import com.example.railwayinformationsystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/system/info/route")
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("route", routeService.getById(id));
        return "route/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("routes", routeService.getAll());
        return "route/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("route", new Route());
        return "route/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Route route, Model model) {
        routeService.save(route);
        model.addAttribute("message", "Route was saved");
        return "redirect:/system/info/route/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        routeService.deleteById(id);
        model.addAttribute("message", "Route was deleted");
        return "redirect:/system/info/route/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("route", routeService.getById(id));
        return "route/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Route route, Model model) {
        routeService.update(route);
        model.addAttribute("message", "Route was updated");
        return "redirect:/system/info/route/all";
    }

    @GetMapping("/cancel")
    public String findAllByCanceled(@RequestParam(value = "canceled") Boolean canceled, Model model) {
        model.addAttribute("routes", routeService.findAllByCanceled(canceled));
        return "route/listByCanceled";
    }

    @GetMapping("/count")
    public String countAllByCanceled(@RequestParam(value = "canceled") Boolean canceled, Model model) {
        model.addAttribute("count", routeService.countAllByCanceled(canceled));
        return "route/countByCanceled";
    }

    @GetMapping("/destination")
    public String findAllByFinalDestination(@RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("routes", routeService.findAllByFinalDestination(finalDestination));
        return "route/listByFinalDestination";
    }

    @GetMapping("/count/destination")
    public String countAllByFinalDestination(@RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", routeService.countAllByFinalDestination(finalDestination));
        return "route/countByFinalDestination";
    }

    @GetMapping("/initialDestination/finalDestination")
    public String findAllByInitialDestinationAndFinalDestination(@RequestParam(value = "initialDestination") String initialDestination,
                                                                 @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("routes", routeService.findAllByInitialDestinationAndFinalDestination(initialDestination, finalDestination));
        return "route/listByInitialDestinationAndFinalDestination";
    }

    @GetMapping("/count/initialDestination/finalDestination")
    public String countAllByInitialDestinationAndFinalDestination(@RequestParam(value = "initialDestination") String initialDestination,
                                                                  @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", routeService.countAllByInitialDestinationAndFinalDestination(initialDestination, finalDestination));
        return "route/countByInitialDestinationAndFinalDestination";
    }

    @GetMapping("/reason/all")
    public String findAllByAllReason(Model model) {
        model.addAttribute("routes", routeService.findAllByDelayReason());
        return "route/listByAllReason";
    }

    @GetMapping("/count/reason/all")
    public String countAllByAllReason(Model model) {
        model.addAttribute("count", routeService.countAllByDelayReason());
        return "route/countByAllReason";
    }

    @GetMapping("/reason")
    public String findAllByReason(@RequestParam(value = "reason") String reason, Model model) {
        model.addAttribute("routes", routeService.findAllByDelayReason(reason));
        return "route/listByReason";
    }

    @GetMapping("/count/reason")
    public String countAllByReason(@RequestParam(value = "reason") String reason, Model model) {
        model.addAttribute("count", routeService.countAllByDelayReason(reason));
        return "route/countByReason";
    }

    @GetMapping("/reason/initialDestination/finalDestination")
    public String findAllByReasonAndDestination(@RequestParam(value = "initialDestination") String initialDestination,
                                                @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("routes", routeService.findAllByDelayReasonAndDestination(initialDestination, finalDestination));
        return "route/listByReasonAndDestination";
    }

    @GetMapping("/count/reason/initialDestination/finalDestination")
    public String countAllByReasonAndDestination(@RequestParam(value = "initialDestination") String initialDestination,
                                                 @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", routeService.countAllByDelayReasonAndDestination(initialDestination, finalDestination));
        return "route/countByReasonAndDestination";
    }

    @GetMapping("/routeType/finalDestination")
    public String findAllByRouteTypeAndFinalDestination(@RequestParam(value = "routeType") String routeType,
                                                        @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("routes", routeService.findAllByRouteTypeAndFinalDestination(routeType, finalDestination));
        return "route/listByRouteTypeAndFinalDestination";
    }

    @GetMapping("/count/routeType/finalDestination")
    public String countAllByRouteTypeAndFinalDestination(@RequestParam(value = "routeType") String routeType,
                                                         @RequestParam(value = "finalDestination") String finalDestination, Model model) {
        model.addAttribute("count", routeService.countAllByRouteTypeAndFinalDestination(routeType, finalDestination));
        return "route/countByRouteTypeAndFinalDestination";
    }

    @GetMapping("/queries")
    public String getQueries(Model model) {
        model.addAttribute("routeTypes", routeService.getAllRouteTypes());
        model.addAttribute("initialDestinations", routeService.getAllInitialDestinations());
        model.addAttribute("finalDestinations", routeService.getAllFinalDestinations());
        return "route/queries";
    }

}
