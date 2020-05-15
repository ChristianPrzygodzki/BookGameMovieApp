package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Game;
import com.przygodzki.bgm_app.enumeration.GameFormat;
import com.przygodzki.bgm_app.to.GameTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameMapperTest {

    @Autowired
    private GameMapper gameMapper;

    @Test
    public void shouldMapEntityToDto(){
        // given
        final Integer expectedId = 77;
        final String expectedTitle = "Call of Duty";
        final float expectedRate = 9.0F;
        final String expectedDescription = "Strzelanka w czasach II wojny światowej.";
        final GameFormat expectedFormat = GameFormat.CD;
        Game gameEntity = new Game(expectedId, expectedTitle, expectedRate, expectedDescription, expectedFormat);

        // when
        Object mappedGame = gameMapper.mapToDto(gameEntity);
        GameTo castedGame = (GameTo) mappedGame;

        // then
        assertEquals(GameTo.class, mappedGame.getClass());
        assertEquals(expectedId, castedGame.getId());
        assertEquals(expectedTitle, castedGame.getTitle());
        assertEquals(expectedRate, castedGame.getRate(), 0.001);
        assertEquals(expectedDescription, castedGame.getDescription());
        assertEquals(expectedFormat, castedGame.getFormat());

    }

    @Test
    public void shouldMapDtoToEntity(){
        // given
        final Integer expectedId = 33;
        final String expectedTitle = "Battlefield 1942";
        final float expectedRate = 6.0F;
        final String expectedDescription = "Weź udział w bitwie II wojny światowej.";
        final GameFormat expectedFormat = GameFormat.CD;
        GameTo gameTo = new GameTo(expectedId, expectedTitle, expectedRate, expectedDescription, expectedFormat);

        // when
        Object mappedGame = gameMapper.mapToEntity(gameTo);
        Game castedGame = (Game) mappedGame;

        // then
        assertEquals(Game.class, mappedGame.getClass());
        assertEquals(expectedId, castedGame.getId());
        assertEquals(expectedTitle, castedGame.getTitle());
        assertEquals(expectedRate, castedGame.getRate(), 0.001);
        assertEquals(expectedDescription, castedGame.getDescription());
        assertEquals(expectedFormat, castedGame.getFormat());

    }

    @Test
    public void shouldMapListOfEntitiesToListOfDtos(){
        // given
        int expectedListSize = 3;
        List<Game> listOfEntities = Arrays.asList(new Game[]{new Game(), null, new Game()});

        // when
        List<GameTo> mappedList = gameMapper.mapToDto(listOfEntities);

        // then
        assertNull(mappedList.get(1));
        assertEquals(GameTo.class, mappedList.get(0).getClass());
        assertEquals(GameTo.class, mappedList.get(2).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }

    @Test
    public void shouldMapListOfDtosToListOfEntities(){
        // given
        int expectedListSize = 4;
        List<GameTo> listOfDtos = Arrays.asList(new GameTo[]{new GameTo(), null, null, new GameTo()});

        // when
        List<Game> mappedList = gameMapper.mapToEntity(listOfDtos);

        // then
        assertNull(mappedList.get(1));
        assertNull(mappedList.get(2));
        assertEquals(Game.class, mappedList.get(0).getClass());
        assertEquals(Game.class, mappedList.get(3).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }
}
