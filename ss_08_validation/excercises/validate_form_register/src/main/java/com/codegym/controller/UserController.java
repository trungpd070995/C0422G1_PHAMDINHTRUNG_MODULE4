package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public String showList(Model model) {
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String checkValidation(@ModelAttribute("userDto") @Valid UserDto userDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        redirectAttributes.addFlashAttribute("message", "Add user successful");
        iUserService.save(user);
        return "redirect:/user";
    }
}