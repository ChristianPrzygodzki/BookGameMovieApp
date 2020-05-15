package com.przygodzki.bgm_app.to;

import com.przygodzki.bgm_app.entity.Actor;

import java.util.List;

public class MovieTo extends CommonTo{

    private List<ActorTo> knownActors;

    public MovieTo() {
    }

    public MovieTo(Integer id, String title, float rate, String description, List<ActorTo> knownActors) {
        super(id, title, rate, description);
        this.knownActors = knownActors;
    }

    public List<ActorTo> getKnownActors() {
        return knownActors;
    }

    public void setKnownActors(List<ActorTo> knownActors) {
        this.knownActors = knownActors;
    }
}
