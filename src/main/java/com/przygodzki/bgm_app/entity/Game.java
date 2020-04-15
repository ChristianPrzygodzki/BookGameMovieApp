package com.przygodzki.bgm_app.entity;

import com.przygodzki.bgm_app.enumeration.Format;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Game extends CommonEntity {

    @Enumerated(EnumType.STRING)
    private Format format;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
