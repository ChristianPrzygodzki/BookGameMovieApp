package com.przygodzki.bgm_app.to;

import com.przygodzki.bgm_app.entity.Actor;

import java.util.List;

public class MovieTo extends CommonTo{

    private List<Actor> knownActors;

    public MovieTo() {
    }

    public MovieTo(Integer id, String title, float rate, String description, List<Actor> knownActors) {
        super(id, title, rate, description);
        this.knownActors = knownActors;
    }

    public List<Actor> getKnownActors() {
        return knownActors;
    }

    public void setKnownActors(List<Actor> knownActors) {
        this.knownActors = knownActors;
    }
}
