package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.to.GameTo;

import java.util.List;

public interface GameService {

    List<GameTo> findAll();

    GameTo findById(Long id);

    List<GameTo> findByTitle(String title);

    GameTo save(GameTo Game);

    // GameTo update(GameTo Game??);

    void delete(Long id);

    // public List<GameTo> findByCriteria(String title, String description);
}
