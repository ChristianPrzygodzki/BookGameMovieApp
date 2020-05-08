package com.przygodzki.bgm_app.service.implementation;

import com.przygodzki.bgm_app.entity.Movie;
import com.przygodzki.bgm_app.mapper.MovieMapper;
import com.przygodzki.bgm_app.repository.MovieRepository;
import com.przygodzki.bgm_app.service.MovieService;
import com.przygodzki.bgm_app.to.MovieTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private MovieMapper movieMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieTo> findAll() {
        return movieMapper.mapToDto(movieRepository.findAll());
    }

    @Override
    public MovieTo findById(Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new NoSuchElementException("Nie ma filmu o podanym id.");
        }
        return movieMapper.mapToDto(movie.get());
    }

    @Override
    public List<MovieTo> findByTitle(String title) {
        return movieMapper.mapToDto(movieRepository.findByTitle(title));
    }

    @Override
    public MovieTo save(MovieTo movie) {
        return movieMapper.mapToDto(movieRepository.save(movieMapper.mapToEntity(movie)));
    }

    @Override
    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }
}
