package com.przygodzki.bgm_app.service.implementation;

import com.przygodzki.bgm_app.entity.Game;
import com.przygodzki.bgm_app.mapper.GameMapper;
import com.przygodzki.bgm_app.repository.GameRepository;
import com.przygodzki.bgm_app.service.GameService;
import com.przygodzki.bgm_app.to.GameTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    private GameMapper gameMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @Override
    public List<GameTo> findAll() {
        return gameMapper.mapToDto(gameRepository.findAll());
    }

    @Override
    public GameTo findById(Integer id) {
        Optional<Game> game = gameRepository.findById(id);
        if (!game.isPresent()) {
            throw new NoSuchElementException("Nie ma gry o podanym id.");
        }
        return gameMapper.mapToDto(game.get());
    }

    @Override
    public List<GameTo> findByTitle(String title) {
        return gameMapper.mapToDto(gameRepository.findByTitle(title));
    }

    @Override
    public GameTo save(GameTo game) {
        return gameMapper.mapToDto(gameRepository.save(gameMapper.mapToEntity(game)));
    }

    @Override
    public void delete(Integer id) {
        gameRepository.deleteById(id);
    }
}
