package com.przygodzki.bgm_app.service.implementation;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.mapper.BookMapper;
import com.przygodzki.bgm_app.repository.BookRepository;
import com.przygodzki.bgm_app.service.BookService;
import com.przygodzki.bgm_app.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookTo> findAll() {
        return bookMapper.mapToDto(bookRepository.findAll());
    }

    @Override
    public BookTo findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new NoSuchElementException("Nie ma książki o podanym id.");
        }
        return bookMapper.mapToDto(book.get());
    }

    @Override
    public List<BookTo> findByTitle(String title) {
        return bookMapper.mapToDto(bookRepository.findByTitle(title));
    }

    @Override
    public BookTo save(BookTo book) {
        return bookMapper.mapToDto(bookRepository.save(bookMapper.mapToEntity(book)));
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
