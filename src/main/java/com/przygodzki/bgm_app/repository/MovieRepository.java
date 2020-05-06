package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
