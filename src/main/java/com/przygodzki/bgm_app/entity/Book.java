package com.przygodzki.bgm_app.entity;

import javax.persistence.Entity;

@Entity
public class Book extends CommonEntity {

    private String author;

    public Book() {
    }

    public Book(String title, float rate, String description, String author) {
        super(title, rate, description);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
