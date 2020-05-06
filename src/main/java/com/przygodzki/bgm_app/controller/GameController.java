package com.przygodzki.bgm_app.controller;

import com.przygodzki.bgm_app.service.GameService;
import com.przygodzki.bgm_app.to.GameTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public String showGames(Model model) {
        List<GameTo> allGames = gameService.findAll();
        model.addAttribute("gameList", allGames);
        // model.addAttribute("searchedGame", new GameTo());
        return "games";
    }
}
