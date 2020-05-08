package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    default List<Book> findByTitle(String title) {
        return this.findAll().stream().filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }

}
