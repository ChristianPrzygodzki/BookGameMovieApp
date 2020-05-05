package com.przygodzki.bgm_app.entity;

import com.przygodzki.bgm_app.enumeration.GameFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Game extends CommonEntity {

    @Enumerated(EnumType.STRING)
    private GameFormat format;

    public GameFormat getFormat() {
        return format;
    }

    public void setFormat(GameFormat format) {
        this.format = format;
    }
}
