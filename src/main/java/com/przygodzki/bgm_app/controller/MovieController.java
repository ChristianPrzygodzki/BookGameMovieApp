package com.przygodzki.bgm_app.controller;

import com.przygodzki.bgm_app.service.MovieService;
import com.przygodzki.bgm_app.to.MovieTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showMovies(Model model) {
        List<MovieTo> allMovies = movieService.findAll();
        model.addAttribute("movieList", allMovies);
        // model.addAttribute("searchedMovie", new MovieTo());
        return "movies";
    }
}
