package com.przygodzki.bgm_app.entity;

import com.przygodzki.bgm_app.enumeration.GameFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Game extends CommonEntity {

    @Enumerated(EnumType.STRING)
    private GameFormat format;

    public Game() {
    }

    public Game(Integer id, String title, float rate, String description, GameFormat format) {
        super(id, title, rate, description);
        this.format = format;
    }

    public GameFormat getFormat() {
        return format;
    }

    public void setFormat(GameFormat format) {
        this.format = format;
    }
}
