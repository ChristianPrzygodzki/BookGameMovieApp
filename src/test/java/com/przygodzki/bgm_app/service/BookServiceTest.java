package com.przygodzki.bgm_app.service;

import com.przygodzki.bgm_app.repository.BookRepository;
import com.przygodzki.bgm_app.to.BookTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldFindAllBooksAndReturnListOfTosWithoutAnyProblems(){
        // given
        int startingNumberOfBooksInDB = 7;

        // when
        List<BookTo> allBooks = bookService.findAll();

        // then
        assertEquals(startingNumberOfBooksInDB,allBooks.size());
    }

    @Test
    public void shouldFindProperBookById(){
        // given
        final int bookId = 3;
        final String expectedTitle = "20000 mil podmorskiej żeglugi";
        final float expectedRate = 8.0F;
        final String excpectedDescription = "Przygody profesora Pierre`a Arronaxa.";
        final String expectedAuthor = "J. Verne";

        // when
        BookTo foundBook = bookService.findById(bookId);

        // then
        assertEquals(expectedTitle, foundBook.getTitle());
        assertEquals(expectedRate, foundBook.getRate(), 0.001);
        assertEquals(excpectedDescription, foundBook.getDescription());
        assertEquals(expectedAuthor, foundBook.getAuthor());
    }

    @Test
    public void shouldFindTwoBooksByPartOfTheirTitle(){
        // given
        final String partOfTitle = " i ";
        final int expectedListSize = 2;
        final String expectedFirstTitle = "Zbrodnia i kara";
        final String expectedSecondTitle = "Harry Potter i Kamień Filozoficzny";

        // when
        List<BookTo> foundBooks = bookService.findByTitle(partOfTitle);

        // then
        assertEquals(expectedListSize, foundBooks.size());
        assertTrue(foundBooks.get(0).getTitle().equals(expectedFirstTitle)
                || foundBooks.get(0).getTitle().equals(expectedSecondTitle));
        assertTrue(foundBooks.get(1).getTitle().equals(expectedFirstTitle)
                || foundBooks.get(1).getTitle().equals(expectedSecondTitle));
    }

    @Test
    public void shouldSaveBookToDB(){
        // given
        int numberOfBooksBeforeSaving = bookRepository.findAll().size();
        BookTo bookToSave = new BookTo(8, "Hobbit", 8.0F, "Wyprawa Bilbo Bagginsa", "J. R. R. Tolkien");

        // when
        BookTo savedBook = bookService.save(bookToSave);

        // then
        assertEquals(bookToSave.getId(), savedBook.getId());
        assertEquals(bookToSave.getTitle(), savedBook.getTitle());
        assertEquals(bookToSave.getRate(), savedBook.getRate(), 0.001);
        assertEquals(bookToSave.getDescription(), savedBook.getDescription());
        assertEquals(bookToSave.getAuthor(), savedBook.getAuthor());
        assertTrue(bookRepository.findById(bookToSave.getId()).isPresent());
        assertEquals(numberOfBooksBeforeSaving + 1, bookRepository.findAll().size());

    }

    @Test
    public void shouldDeleteBookFromDB(){
        // given
        int bookToDeleteId = 4;
        int expectedSizeOfBookList = bookRepository.findAll().size() - 1;

        // when
        bookService.delete(bookToDeleteId);

        // then
        assertFalse(bookRepository.findById(4).isPresent());
        assertEquals(expectedSizeOfBookList, bookRepository.findAll().size());
    }
}
