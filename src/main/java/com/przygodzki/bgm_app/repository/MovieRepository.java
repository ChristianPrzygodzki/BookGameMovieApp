package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    default List<Movie> findByTitle(String title) {
        return this.findAll().stream().filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }
}
