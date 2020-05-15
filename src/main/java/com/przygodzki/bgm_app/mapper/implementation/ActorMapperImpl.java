package com.przygodzki.bgm_app.mapper.implementation;

import com.przygodzki.bgm_app.entity.Actor;
import com.przygodzki.bgm_app.mapper.ActorMapper;
import com.przygodzki.bgm_app.to.ActorTo;
import com.przygodzki.bgm_app.to.BookTo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorTo mapToDto(Actor actor) {
        if (actor != null) {
            return new ActorTo(
                    actor.getId(),
                    actor.getName(),
                    actor.getSurname());
        }
        return null;
    }

    @Override
    public Actor mapToEntity(ActorTo actorTo) {
        if (actorTo != null) {
            return new Actor(
                    actorTo.getId(),
                    actorTo.getName(),
                    actorTo.getSurname());
        }
        return null;
    }

    @Override
    public List<ActorTo> mapToDto(List<Actor> actorEntities) {
        if(actorEntities==null){
            return null;
        }
        return actorEntities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<Actor> mapToEntity(List<ActorTo> actorTos) {
        if(actorTos==null){
            return null;
        }
        return actorTos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
