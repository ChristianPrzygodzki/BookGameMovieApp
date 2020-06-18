package com.przygodzki.bgm_app.controller;

import com.przygodzki.bgm_app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

//    public List<Book> books;

    public HomeController() {
        /*this.books = new ArrayList<>();
        Book book1 = new Book(1, "Bible", 10, "History of salvation.", "God");
        Book book2 = new Book(2, "Illiade", 9, "Legend of troyan war.", "Homer");
        books.add(book1);
        books.add(book2);*/
    }

    @RequestMapping("/")
    public String index() {
        return "home";
    }

}


