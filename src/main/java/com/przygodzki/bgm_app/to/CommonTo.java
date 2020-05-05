package com.przygodzki.bgm_app.to;

public class CommonTo {

    protected Integer id;

    protected String title;

    protected float rate;

    protected String description;

    public CommonTo() {
    }

    public CommonTo(Integer id, String title, float rate, String description) {
        this.id = id;
        this.title = title;
        this.rate = rate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
