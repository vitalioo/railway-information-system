package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Cashier;
import com.example.railwayinformationsystem.service.CashierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/system/info/cashier")
public class CashierController {
    private final CashierService cashierService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        Cashier cashier = cashierService.getById(id);
        model.addAttribute("cashier", cashier);
        return "cashier/detail";
    }

    @PostMapping("")
    public String save(@RequestBody Cashier cashier, Model model) {
        cashierService.save(cashier);
        model.addAttribute("message", "Cashier was saved");
        return "redirect:/system/info/cashier/all";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        cashierService.deleteById(id);
        model.addAttribute("message", "Cashier was deleted");
        return "redirect:/system/info/cashier/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Cashier> cashiers = cashierService.getAll();
        model.addAttribute("cashiers", cashiers);
        return "cashier/list";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") Integer id, @RequestBody Cashier cashier, Model model) {
        cashierService.update(cashier);
        model.addAttribute("message", "Cashier was updated");
        return "redirect:/system/info/cashier/all";
    }
}
