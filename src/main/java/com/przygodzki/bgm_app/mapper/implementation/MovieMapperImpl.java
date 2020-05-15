package com.przygodzki.bgm_app.mapper.implementation;

import com.przygodzki.bgm_app.entity.Movie;
import com.przygodzki.bgm_app.mapper.ActorMapper;
import com.przygodzki.bgm_app.mapper.MovieMapper;
import com.przygodzki.bgm_app.to.MovieTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {

    private ActorMapper actorMapper;

    @Autowired
    public MovieMapperImpl(ActorMapper actorMapper) {
        this.actorMapper = actorMapper;
    }

    @Override
    public MovieTo mapToDto(Movie movie) {
        if (movie != null) {
            return new MovieTo(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getRate(),
                    movie.getDescription(),
                    actorMapper.mapToDto(movie.getKnownActors()));
        }
        return null;
    }

    @Override
    public Movie mapToEntity(MovieTo movieTo) {
        if (movieTo != null) {
            return new Movie(
                    movieTo.getId(),
                    movieTo.getTitle(),
                    movieTo.getRate(),
                    movieTo.getDescription(),
                    actorMapper.mapToEntity(movieTo.getKnownActors()));
        }
        return null;
    }

    @Override
    public List<MovieTo> mapToDto(List<Movie> movieEntities) {
        return movieEntities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<Movie> mapToEntity(List<MovieTo> movieTos) {
        return movieTos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
    
}
