package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Actor;
import com.przygodzki.bgm_app.entity.Movie;
import com.przygodzki.bgm_app.to.ActorTo;
import com.przygodzki.bgm_app.to.MovieTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void shouldMapEntityToDto(){
        // given
        final Integer expectedId = 15;
        final String expectedTitle = "Titanic";
        final float expectedRate = 8.0F;
        final String expectedDescription = "Katastrofa Titanica";
        final Actor actor1 = new Actor(1, "Kate", "Winslet");
        final Actor actor2 = new Actor(2, "Leonardo", "di Caprio");
        final List<Actor> knownActors = Arrays.asList(actor1, actor2);
        final String expectedActor0Name = "Kate";
        final String expectedActor1Surname = "di Caprio";
        final Movie movieEntity = new Movie(expectedId, expectedTitle, expectedRate, expectedDescription, knownActors);

        // when
        Object mappedMovie = movieMapper.mapToDto(movieEntity);
        MovieTo castedMovie = (MovieTo) mappedMovie;

        // then
        assertEquals(MovieTo.class, mappedMovie.getClass());
        assertEquals(expectedId, castedMovie.getId());
        assertEquals(expectedTitle, castedMovie.getTitle());
        assertEquals(expectedRate, castedMovie.getRate(), 0.001);
        assertEquals(expectedDescription, castedMovie.getDescription());
        assertEquals(expectedActor0Name, castedMovie.getKnownActors().get(0).getName());
        assertEquals(expectedActor1Surname, castedMovie.getKnownActors().get(1).getSurname());

    }

    @Test
    public void shouldMapDtoToEntity(){
        // given
        final Integer expectedId = 30;
        final String expectedTitle = "Zielona Mila";
        final float expectedRate = 10.0F;
        final String expectedDescription = "Nietypowy skazaniec.";
        final ActorTo actorTo1 = new ActorTo(1, "Tom", "Hanks");
        final ActorTo actorTo2 = new ActorTo(2, "Michael", "Clarke Duncan");
        final List<ActorTo> knownActors = Arrays.asList(actorTo1, actorTo2);
        final String expectedActor0Surname = "Hanks";
        final String expectedActor1Name = "Michael";
        final MovieTo movieTo = new MovieTo(expectedId, expectedTitle, expectedRate, expectedDescription, knownActors);

        // when
        Object mappedMovie = movieMapper.mapToEntity(movieTo);
        Movie castedMovie = (Movie) mappedMovie;

        // then
        assertEquals(Movie.class, mappedMovie.getClass());
        assertEquals(expectedId, castedMovie.getId());
        assertEquals(expectedTitle, castedMovie.getTitle());
        assertEquals(expectedRate, castedMovie.getRate(), 0.001);
        assertEquals(expectedDescription, castedMovie.getDescription());
        assertEquals(expectedActor0Surname, castedMovie.getKnownActors().get(0).getSurname());
        assertEquals(expectedActor1Name, castedMovie.getKnownActors().get(1).getName());

    }

    @Test
    public void shouldMapListOfEntitiesToListOfDtos(){
        // given
        int expectedListSize = 3;
        List<Movie> listOfEntities = Arrays.asList(new Movie[]{new Movie(), null, new Movie()});

        // when
        List<MovieTo> mappedList = movieMapper.mapToDto(listOfEntities);

        // then
        assertNull(mappedList.get(1));
        assertEquals(MovieTo.class, mappedList.get(0).getClass());
        assertEquals(MovieTo.class, mappedList.get(2).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }

    @Test
    public void shouldMapListOfDtosToListOfEntities(){
        // given
        int expectedListSize = 4;
        List<MovieTo> listOfDtos = Arrays.asList(new MovieTo[]{new MovieTo(), null, null, new MovieTo()});

        // when
        List<Movie> mappedList = movieMapper.mapToEntity(listOfDtos);

        // then
        assertNull(mappedList.get(1));
        assertNull(mappedList.get(2));
        assertEquals(Movie.class, mappedList.get(0).getClass());
        assertEquals(Movie.class, mappedList.get(3).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }
}
