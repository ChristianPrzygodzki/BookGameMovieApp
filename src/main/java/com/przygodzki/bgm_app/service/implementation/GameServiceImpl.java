package com.przygodzki.bgm_app.service.implementation;

import com.przygodzki.bgm_app.mapper.GameMapper;
import com.przygodzki.bgm_app.repository.GameRepository;
import com.przygodzki.bgm_app.service.GameService;
import com.przygodzki.bgm_app.to.GameTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    private GameMapper gameMapper;

    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @Autowired



    @Override
    public List<GameTo> findAll() {
        return null;
    }

    @Override
    public GameTo findById(Long id) {
        return null;
    }

    @Override
    public List<GameTo> findByTitle(String title) {
        return null;
    }

    @Override
    public GameTo save(GameTo Game) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
