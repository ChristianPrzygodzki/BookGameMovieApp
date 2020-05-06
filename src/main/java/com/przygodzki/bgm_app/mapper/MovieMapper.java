package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Movie;
import com.przygodzki.bgm_app.to.MovieTo;

import java.util.List;

public interface MovieMapper {

    MovieTo mapToTo(Movie movie);

    Movie mapToEntity(MovieTo movieTo);

    List<MovieTo> mapToTo(List<Movie> movieEntities);

    List<Movie> mapToEntity(List<MovieTo> movieEntities);
}
