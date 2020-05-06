package com.przygodzki.bgm_app.mapper.implementation;

import com.przygodzki.bgm_app.entity.Game;
import com.przygodzki.bgm_app.mapper.GameMapper;
import com.przygodzki.bgm_app.to.GameTo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapperImpl implements GameMapper {

    @Override
    public GameTo mapToTo(Game game) {
        if (game != null) {
            return new GameTo(
                    game.getId(),
                    game.getTitle(),
                    game.getRate(),
                    game.getDescription(),
                    game.getFormat());
        }
        return null;
    }

    @Override
    public Game mapToEntity(GameTo gameTo) {
        if (gameTo != null) {
            return new Game(
                    gameTo.getId(),
                    gameTo.getTitle(),
                    gameTo.getRate(),
                    gameTo.getDescription(),
                    gameTo.getFormat());
        }
        return null;
    }

    @Override
    public List<GameTo> mapToTo(List<Game> gameEntities) {
        return gameEntities.stream().map(this::mapToTo).collect(Collectors.toList());
    }

    @Override
    public List<Game> mapToEntity(List<GameTo> gameTos) {
        return gameTos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
