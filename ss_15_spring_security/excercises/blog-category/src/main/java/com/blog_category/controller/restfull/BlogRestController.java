package com.blog_category.controller.restfull;

import com.blog_category.model.Blog;
import com.blog_category.model.Category;
import com.blog_category.service.IBlogService;
import com.blog_category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault Pageable pageable, @RequestParam("name") Optional<String> name) {
        String keyName = name.orElse("");
        Page<Blog> blogPage = blogService.findAll(pageable, keyName);
        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/findByCategoryId/{id}")
    public ResponseEntity<Page<Blog>> findByCategoryId(@PathVariable Long id,
                                                       @PageableDefault(size = 5) Pageable pageable){
        Page<Blog> blogPage = blogService.findAllBlogByCategoryId(id, pageable);
        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/viewBlog/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
