package com.codegym.application_expansion_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codegym.application_expansion_blog.model.Blog;
import com.codegym.application_expansion_blog.model.Category;
import com.codegym.application_expansion_blog.service.IBlogService;
import com.codegym.application_expansion_blog.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public String showBlog(Model model,
                           @PageableDefault(size = 2) Pageable pageable) {
        List<Category> categoryList = iCategoryService.findAll();
        Page<Blog> blogList = iBlogService.findAll(pageable);

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog";
    }

    @GetMapping("/sort")
    public String sortBlog(@PageableDefault(size = 5, sort = "dateCreate", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        Page<Blog> blogList = iBlogService.findAll(pageable);

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", iBlogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        iBlogService.remove(id);
        return "redirect:";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") String keyword, Model model) {
        Page<Blog> blogList = iBlogService.find(keyword, pageable);
        List<Category> categoryList = iCategoryService.findAll();

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog";
    }

}
