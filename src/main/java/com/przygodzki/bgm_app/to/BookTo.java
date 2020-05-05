package com.przygodzki.bgm_app.to;

public class BookTo extends CommonTo{

    private String author;

    public BookTo() {
    }

    public BookTo(Integer id, String title, float rate, String description, String author) {
        super(id, title, rate, description);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
