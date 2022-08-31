package com.codegym.controller;

import com.codegym.dto.CategoryDto;
import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories/api/v1")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = iCategoryService.findAll();

        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        iCategoryService.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Category currentCategory = iCategoryService.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(categoryDto.getName());
        iCategoryService.save(currentCategory);
        return new ResponseEntity(currentCategory, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id) {
        Category currentCategory = iCategoryService.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        iCategoryService.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
