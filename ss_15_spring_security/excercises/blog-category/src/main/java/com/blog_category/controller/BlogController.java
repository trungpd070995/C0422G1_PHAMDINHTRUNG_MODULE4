package com.blog_category.controller;

import com.blog_category.model.Blog;
import com.blog_category.model.Category;
import com.blog_category.service.IBlogService;
import com.blog_category.service.ICategoryService;
import com.blog_category.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String listBlog(Model model,
                           @PageableDefault(size = 5) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam Optional<String> categoryName,
                           Principal principal){
        String keyName = name.orElse("");
        String categoryNames = categoryName.orElse("");
        Page<Blog> blogPage = blogService.findAll(keyName, categoryNames, pageable);
        model.addAttribute("blogList", blogPage);
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("keyVal", keyName);
        if (principal == null){
            return "/blog/list";
        }
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getAuthorities());
        return "/blog/list";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlog(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/blog/info");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/showFormCreate")
    public ModelAndView formCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("category", categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView formEditBlog(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category", categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog/list");
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam long id){
        blogService.remove(id);
        return "redirect:/blog/list";
    }

    @GetMapping("/showFormCreateCategory")
    public ModelAndView ShowFormCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView createCategory(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        categoryService.save(category);
        return modelAndView;
    }
}
