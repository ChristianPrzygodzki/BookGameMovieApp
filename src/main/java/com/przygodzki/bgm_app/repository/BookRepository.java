package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
