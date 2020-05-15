package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Actor;
import com.przygodzki.bgm_app.to.ActorTo;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ActorMapper {

    ActorTo mapToDto(Actor actor);

    Actor mapToEntity(ActorTo actorTo);

    List<ActorTo> mapToDto(List<Actor> actorEntities);

    List<Actor> mapToEntity(List<ActorTo> actorTos);
}
