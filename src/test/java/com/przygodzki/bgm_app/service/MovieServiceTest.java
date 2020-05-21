package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.repository.MovieRepository;
import com.przygodzki.bgm_app.to.MovieTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldFindAllMoviesAndReturnListOfTosWithoutAnyProblems(){
        // given
        int startingNumberOfMoviesInDB = 5;

        // when
        List<MovieTo> allMovies = movieService.findAll();

        // then
        assertEquals(startingNumberOfMoviesInDB,allMovies.size());
    }

    @Test
    public void shouldFindProperMovieById(){
        // given
        final int movieId = 1;
        final String expectedTitle = "Ogniem i mieczem";
        final float expectedRate = 9.0F;
        final String excpectedDescription = "Adaptacja powieści Henryka Sienkiewicza.";

        // when
        MovieTo foundMovie = movieService.findById(movieId);

        // then
        assertEquals(expectedTitle, foundMovie.getTitle());
        assertEquals(expectedRate, foundMovie.getRate(), 0.001);
        assertEquals(excpectedDescription, foundMovie.getDescription());
    }

    @Test
    public void shouldFindTwoMoviesByPartOfTheirTitle(){
        // given
        final String partOfTitle = "ie";
        final int expectedListSize = 2;
        final String expectedFirstTitle = "Ogniem i mieczem";
        final String expectedSecondTitle = "Leon Zawodowiec";

        // when
        List<MovieTo> foundMovies = movieService.findByTitle(partOfTitle);

        // then
        assertEquals(expectedListSize, foundMovies.size());
        assertTrue(foundMovies.get(0).getTitle().equals(expectedFirstTitle)
                || foundMovies.get(0).getTitle().equals(expectedSecondTitle));
        assertTrue(foundMovies.get(1).getTitle().equals(expectedFirstTitle)
                || foundMovies.get(1).getTitle().equals(expectedSecondTitle));
    }

    @Test
    public void shouldSaveMovieToDB(){
        // given
        int numberOfMoviesBeforeSaving = movieRepository.findAll().size();
        MovieTo movieToSave = new MovieTo(6, "Pianista", 7.0F, "O Szpilmanie.", null);

        // when
        MovieTo savedMovie = movieService.save(movieToSave);

        // then
        assertEquals(movieToSave.getId(), savedMovie.getId());
        assertEquals(movieToSave.getTitle(), savedMovie.getTitle());
        assertEquals(movieToSave.getRate(), savedMovie.getRate(), 0.001);
        assertEquals(movieToSave.getDescription(), savedMovie.getDescription());
        assertEquals(null, movieToSave.getKnownActors());
        assertTrue(movieRepository.findById(movieToSave.getId()).isPresent());
        assertEquals(numberOfMoviesBeforeSaving + 1, movieRepository.findAll().size());

    }

    @Test
    public void shouldDeleteMovieFromDB(){
        // given
        int movieToDeleteId = 4;
        int expectedSizeOfMovieList = movieRepository.findAll().size() - 1;

        // when
        movieService.delete(movieToDeleteId);

        // then
        assertFalse(movieRepository.findById(4).isPresent());
        assertEquals(expectedSizeOfMovieList, movieRepository.findAll().size());
    }

}
