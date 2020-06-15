package com.przygodzki.bgm_app;

import com.przygodzki.bgm_app.entity.Game;
import com.przygodzki.bgm_app.repository.GameRepository;
import com.przygodzki.bgm_app.service.GameService;
import com.przygodzki.bgm_app.service.implementation.GameServiceImpl;
import com.przygodzki.bgm_app.to.GameTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BookGameMovieApp {


    private static GameRepository gameRepo;

    @Autowired
    public void setGameRepo(GameRepository gameRepo) {
        BookGameMovieApp.gameRepo = gameRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookGameMovieApp.class, args);
    }
}
