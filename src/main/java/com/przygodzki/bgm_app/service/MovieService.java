package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.to.MovieTo;

import java.util.List;

public interface MovieService {

    List<MovieTo> findAll();

    MovieTo findById(Long id);

    List<MovieTo> findByTitle(String title);

    MovieTo save(MovieTo Movie);

    // MovieTo update(MovieTo Movie??);

    void delete(Long id);

    // public List<MovieTo> findByCriteria(String title, String author, String description);
}
