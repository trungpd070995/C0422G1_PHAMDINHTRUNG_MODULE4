package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musics", musicService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        music.setIdTheSong((int) (Math.random() * 1000));
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Add product successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findOne(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        musicService.update(music);
        return "redirect:/music";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        musicService.delete(idDelete);
        redirectAttributes.addFlashAttribute("success", "Delete product successfully!");
        return "redirect:/music";
    }
}