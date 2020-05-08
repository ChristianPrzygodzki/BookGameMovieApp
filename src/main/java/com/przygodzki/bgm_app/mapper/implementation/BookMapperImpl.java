package com.przygodzki.bgm_app.mapper.implementation;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.mapper.BookMapper;
import com.przygodzki.bgm_app.to.BookTo;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookTo mapToDto(Book book) {
        if (book != null) {
            return new BookTo(
                    book.getId(),
                    book.getTitle(),
                    book.getRate(),
                    book.getDescription(),
                    book.getAuthor());
        }
        return null;
    }

    @Override
    public Book mapToEntity(BookTo bookTo) {
        if (bookTo != null) {
            return new Book(
                    bookTo.getId(),
                    bookTo.getTitle(),
                    bookTo.getRate(),
                    bookTo.getDescription(),
                    bookTo.getAuthor());
        }
        return null;
    }

    @Override
    public List<BookTo> mapToDto(List<Book> bookEntities) {
        return bookEntities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<Book> mapToEntity(List<BookTo> bookTos) {
        return bookTos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
