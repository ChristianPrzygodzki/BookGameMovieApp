package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.enumeration.GameFormat;
import com.przygodzki.bgm_app.repository.GameRepository;
import com.przygodzki.bgm_app.to.GameTo;
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
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void shouldFindAllGamesAndReturnListOfTosWithoutAnyProblems(){
        // given
        int startingNumberOfGamesInDB = 4;

        // when
        List<GameTo> allGames = gameService.findAll();

        // then
        assertEquals(startingNumberOfGamesInDB,allGames.size());
    }

    @Test
    public void shouldFindProperGameById(){
        // given
        final int gameId = 2;
        final String expectedTitle = "Warcraft III";
        final float expectedRate = 10.0F;
        final String excpectedDescription = "RTS, where You can play as Human, Orc, Night Elf or Undead.";
        final GameFormat expectedFormat = GameFormat.OTHER_LICENCE;

        // when
        GameTo foundGame = gameService.findById(gameId);

        // then
        assertEquals(expectedTitle, foundGame.getTitle());
        assertEquals(expectedRate, foundGame.getRate(), 0.001);
        assertEquals(excpectedDescription, foundGame.getDescription());
        assertEquals(expectedFormat, foundGame.getFormat());
    }

    @Test
    public void shouldFindTwoGamesByPartOfTheirTitle(){
        // given
        final String partOfTitle = ":";
        final int expectedListSize = 2;
        final String expectedFirstTitle = "CS:GO";
        final String expectedSecondTitle = "Kozacy: Powrót na wojnę";

        // when
        List<GameTo> foundGames = gameService.findByTitle(partOfTitle);

        // then
        assertEquals(expectedListSize, foundGames.size());
        assertTrue(foundGames.get(0).getTitle().equals(expectedFirstTitle)
                || foundGames.get(0).getTitle().equals(expectedSecondTitle));
        assertTrue(foundGames.get(1).getTitle().equals(expectedFirstTitle)
                || foundGames.get(1).getTitle().equals(expectedSecondTitle));
    }

    @Test
    public void shouldSaveGameToDB(){
        // given
        int expectedNumberOfGames = gameRepository.findAll().size() + 1;
        GameTo gameToSave = new GameTo(5, "Syberia I", 7.0F, "Searching for heir of automotons factory.", GameFormat.STEAM);

        // when
        GameTo savedGame = gameService.save(gameToSave);

        // then
        assertEquals(gameToSave.getId(), savedGame.getId());
        assertEquals(gameToSave.getTitle(), savedGame.getTitle());
        assertEquals(gameToSave.getRate(), savedGame.getRate(), 0.001);
        assertEquals(gameToSave.getDescription(), savedGame.getDescription());
        assertEquals(gameToSave.getFormat(), savedGame.getFormat());
        assertTrue(gameRepository.findById(gameToSave.getId()).isPresent());
        assertEquals(expectedNumberOfGames, gameRepository.findAll().size());

    }

    @Test
    public void shouldDeleteGameFromDB(){
        // given
        int gameToDeleteId = 4;
        int expectedSizeOfGameList = gameRepository.findAll().size() - 1;

        // when
        gameService.delete(gameToDeleteId);

        // then
        assertFalse(gameRepository.findById(4).isPresent());
        assertEquals(expectedSizeOfGameList, gameRepository.findAll().size());
    }
}
