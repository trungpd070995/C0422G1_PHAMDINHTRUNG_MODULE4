package com.codegym.controller;

import com.codegym.dto.SongInfoDto;
import com.codegym.model.SongInfo;
import com.codegym.service.ISongInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongInfoController {

    @Autowired
    private ISongInfoService iSongInfoService;

    @GetMapping("/song")
    public String showList(Model model) {
        List<SongInfo> songInfoList = iSongInfoService.findAll();
        model.addAttribute("songInfoList", songInfoList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songInfoDto", new SongInfoDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("songInfoDto")@Valid SongInfoDto songInfoDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        SongInfo songInfo = new SongInfo();
        BeanUtils.copyProperties(songInfoDto, songInfo);
        redirectAttributes.addFlashAttribute("message", "Add song successful");
        iSongInfoService.save(songInfo);
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("songInfoDto", iSongInfoService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("songInfoDto") SongInfoDto songInfoDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        SongInfo songInfo = new SongInfo();
        BeanUtils.copyProperties(songInfoDto, songInfo);
        redirectAttributes.addFlashAttribute("message", "Update song successful");
        iSongInfoService.save(songInfo);
        return "redirect:/song";
    }

}
