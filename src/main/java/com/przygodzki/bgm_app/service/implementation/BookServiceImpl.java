package com.przygodzki.bgm_app.service.implementation;

import com.przygodzki.bgm_app.service.BookService;
import com.przygodzki.bgm_app.to.BookTo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<BookTo> findAll() {
        List<BookTo> list = new ArrayList<>();
        BookTo book1 = new BookTo(1, "Pan Kleks", 5.0F, "Nie pamiętam o czym.", "Jan Brzechwa");
        BookTo book2 = new BookTo(2, "Pan Hilary", 5.0F, "Okulary itd.", "Julian Tuwim");
        list.add(book1);
        list.add(book2);
        return list;
    }

    @Override
    public BookTo findById(Long id) {
        return null;
    }

    @Override
    public List<BookTo> findByTitle(String title) {
        return null;
    }

    @Override
    public BookTo save(BookTo book) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
