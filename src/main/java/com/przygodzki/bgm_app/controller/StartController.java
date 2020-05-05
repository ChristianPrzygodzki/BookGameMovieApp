package com.przygodzki.bgm_app.controller;

import com.przygodzki.bgm_app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {

    public List<Book> books;

    public StartController() {
        this.books = new ArrayList<>();
        Book book1 = new Book("Bible", 10, "History of salvation.", "God");
        Book book2 = new Book("Illiade", 9, "Legend of troyan war.", "Homer");
        books.add(book1);
        books.add(book2);
    }

    @RequestMapping("/books")
    public String index(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

}


