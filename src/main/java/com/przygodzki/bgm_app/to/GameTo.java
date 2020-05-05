package com.przygodzki.bgm_app.to;

import com.przygodzki.bgm_app.enumeration.GameFormat;

public class GameTo extends CommonTo{

    private GameFormat format;

    public GameTo() {
    }

    public GameTo(Integer id, String title, float rate, String description, GameFormat format) {
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
