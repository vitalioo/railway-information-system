package com.example.railwayinformationsystem.controller;

import com.example.railwayinformationsystem.model.entity.Driver;
import com.example.railwayinformationsystem.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/system/info/driver")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id, Model model) {
        Driver driver = driverService.getById(id);
        model.addAttribute("driver", driver);
        return "driver/detail";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("drivers", driverService.getAll());
        return "driver/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("driver", new Driver());
        return "driver/create";
    }

    @PostMapping("")
    public String save(@ModelAttribute Driver driver, Model model) {
        driverService.save(driver);
        model.addAttribute("message", "Driver was saved");
        return "redirect:/system/info/driver/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
        driverService.deleteById(id);
        model.addAttribute("message", "Driver was deleted");
        return "redirect:/system/info/driver/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        Driver driver = driverService.getById(id);
        model.addAttribute("driver", driver);
        return "driver/update";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute Driver driver, Model model) {
        driverService.update(driver);
        model.addAttribute("message", "Driver was updated");
        return "redirect:/system/info/driver/all";
    }

    @GetMapping("/med-exam/passed")
    public String getAllPassedMedicalExamination(@RequestParam("medicalExamination") Short medicalExamination, Model model) {
        List<Driver> drivers = driverService.getAllPassedMedicalExamination(medicalExamination);
        model.addAttribute("drivers", drivers);
        return "driver/listMedicalPassed";
    }

    @GetMapping("/count/med-exam/passed")
    public String getCountAllPassedMedicalExamination(@RequestParam("medicalExamination") Short medicalExamination, Model model) {
        int count = driverService.getCountAllPassedMedicalExamination(medicalExamination);
        model.addAttribute("count", count);
        return "driver/countMedicalPassed";
    }

    @GetMapping("/medexam/failed")
    public String getAllFailedMedicalExamination(@RequestParam("medicalExamination") Short medicalExamination, Model model) {
        List<Driver> drivers = driverService.getAllFailedMedicalExamination(medicalExamination);
        model.addAttribute("drivers", drivers);
        return "driver/listMedicalFailed";
    }

    @GetMapping("/count/med-exam/failed")
    public String getCountAllFailedMedicalExamination(@RequestParam("medicalExamination") Short medicalExamination, Model model) {
        int count = driverService.getCountAllFailedMedicalExamination(medicalExamination);
        model.addAttribute("count", count);
        return "driver/countMedicalFailed";
    }

    @GetMapping("/gender")
    public String getAllByGender(@RequestParam(value = "gender") Character gender, Model model) {
        List<Driver> drivers = driverService.getAllByGender(gender);
        model.addAttribute("drivers", drivers);
        return "driver/listByGender";
    }

    @GetMapping("/count/gender")
    public String getCountAllByGender(@RequestParam(value = "gender") Character gender, Model model) {
        int count = driverService.getCountAllByGender(gender);
        model.addAttribute("count", count);
        return "driver/countByGender";
    }

    @GetMapping("/age")
    public String getByAge(@RequestParam(value = "age") Short age, Model model) {
        List<Driver> drivers = driverService.getAllByAge(age);
        model.addAttribute("drivers", drivers);
        return "driver/listByAge";
    }

    @GetMapping("/count/age")
    public String getCountAllByAge(@RequestParam(value = "age") Short age, Model model) {
        int count = driverService.getCountAllByAge(age);
        model.addAttribute("count", count);
        return "driver/countByAge";
    }

    @GetMapping("/salary")
    public String getBySalary(@RequestParam(value = "salary") Integer salary, Model model) {
        List<Driver> drivers = driverService.getAllBySalary(salary);
        model.addAttribute("drivers", drivers);
        return "driver/listSalary";
    }

    @GetMapping("/count/salary")
    public String getCountAllBySalary(@RequestParam(value = "salary") Integer salary, Model model) {
        int count = driverService.getCountAllBySalary(salary);
        model.addAttribute("count", count);
        return "driver/countSalary";
    }

    @GetMapping("/queries")
    public String queries() {
        return "driver/queries";
    }
}