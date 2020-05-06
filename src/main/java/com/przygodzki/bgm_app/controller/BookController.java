package com.przygodzki.bgm_app.controller;

import com.przygodzki.bgm_app.service.BookService;
import com.przygodzki.bgm_app.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<BookTo> allBooks = bookService.findAll();
        model.addAttribute("bookList", allBooks);
        // model.addAttribute("searchedBook", new BookTo());
        return "books";
    }
}
