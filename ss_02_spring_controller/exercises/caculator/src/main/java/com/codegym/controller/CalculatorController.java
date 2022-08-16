package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("")
    public String result(@RequestParam String number1, String number2, String calculator, Model model) {
        String result = calculatorService.result(number1, number2, calculator);
        model.addAttribute("result", result);
        return "index";
    }

}
