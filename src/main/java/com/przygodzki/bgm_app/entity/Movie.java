package com.przygodzki.bgm_app.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Movie extends CommonEntity {

    @ManyToMany
    @JoinTable(
            name = "MOVIE_TO_ACTOR",
            joinColumns = @JoinColumn(name = "MOVIE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    private List<Actor> knownActors;

    public List<Actor> getKnownActors() {
        return knownActors;
    }

    public void setKnownActors(List<Actor> knownActors) {
        this.knownActors = knownActors;
    }
}
