package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Game;
import com.przygodzki.bgm_app.to.GameTo;

import java.util.List;

public interface GameMapper {

    GameTo mapToTo(Game game);

    Game mapToEntity(GameTo gameTo);

    List<GameTo> mapToTo(List<Game> gameEntities);

    List<Game> mapToEntity(List<GameTo> gameEntities);
    
}
