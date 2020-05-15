package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.to.BookTo;

import java.util.List;

public interface BookMapper {

    BookTo mapToDto(Book book);

    Book mapToEntity(BookTo bookTo);

    List<BookTo> mapToDto(List<Book> bookEntities);

    List<Book> mapToEntity(List<BookTo> bookTos);
}
