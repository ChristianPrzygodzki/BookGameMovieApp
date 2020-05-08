package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.to.BookTo;

import java.util.List;

public interface BookService {

    List<BookTo> findAll();

    BookTo findById(Integer id);

    List<BookTo> findByTitle(String title);

    BookTo save(BookTo book);

    // BookTo update(BookTo book??);

    void delete(Integer id);

    // public List<BookTo> findByCriteria(String title, String author, String description);
}
