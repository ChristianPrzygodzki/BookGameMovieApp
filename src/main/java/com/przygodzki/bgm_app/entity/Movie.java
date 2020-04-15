package com.przygodzki.bgm_app.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Movie extends CommonEntity {

    @ManyToMany
    private List<Actor> knownActors;

    public List<Actor> getKnownActors() {
        return knownActors;
    }

    public void setKnownActors(List<Actor> knownActors) {
        this.knownActors = knownActors;
    }
}
