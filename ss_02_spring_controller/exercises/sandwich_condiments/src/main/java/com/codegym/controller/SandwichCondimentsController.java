package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codegym.service.ISpiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SandwichCondimentsController {

    @Autowired
    private ISpiceService spiceService;

    @GetMapping("/")
    private String home(Model model) {
        model.addAttribute("condiment", this.spiceService.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String saveSpice(@RequestParam String[] select, Model model){
        model.addAttribute("save",this.spiceService.save(select));
        model.addAttribute("condiment", this.spiceService.findAll());
        return "index";
    }

}
