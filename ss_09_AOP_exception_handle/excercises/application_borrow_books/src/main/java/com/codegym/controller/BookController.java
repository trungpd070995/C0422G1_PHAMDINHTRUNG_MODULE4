package com.codegym.controller;

import com.codegym.exception.BookException;
import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping(value = "/books")
    public String listBook(Model model) {
        List<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detailBook(@PathVariable Integer id, Model model) throws BookException {
        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0) {
            throw new BookException();
        } else {
            model.addAttribute("book", book);
            return "/detail";
        }
    }

    @PostMapping("/detail")
    public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "successfully borrowed the book!");
        return "redirect:/books";
    }

    @GetMapping("/give-book-back")
    public String showForm() {
        return "/pay";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "successfully returned the book!");
        return "redirect:/books";
    }

    @ExceptionHandler(BookException.class)
    public String showException() {
        return "/error";
    }
}
