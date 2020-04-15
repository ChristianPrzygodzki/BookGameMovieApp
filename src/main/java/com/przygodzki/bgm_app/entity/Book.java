package com.przygodzki.bgm_app.entity;

import javax.persistence.Entity;

@Entity
public class Book extends CommonEntity {

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
