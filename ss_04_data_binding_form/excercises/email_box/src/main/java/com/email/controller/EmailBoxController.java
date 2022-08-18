package com.email.controller;

import com.email.model.EmailBox;
import com.email.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailBoxController {

    @Autowired
    private IEmailBoxService emailBoxService;

    @GetMapping("")
    public String showEmailBox(Model model) {
        model.addAttribute("emailBox", this.emailBoxService.findAll());
        model.addAttribute("language", emailBoxService.findLanguage());
        model.addAttribute("pageSize", emailBoxService.findPageSize());
        return "index";
    }

    @PostMapping("/result")
    public String updateShowForm(@ModelAttribute ("email") EmailBox emailBox ,Model model){
        emailBoxService.save(emailBox);
        model.addAttribute("emailSetting", this.emailBoxService.findAll());
        return "result";
    }

}
