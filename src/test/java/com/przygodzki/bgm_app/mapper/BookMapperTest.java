package com.przygodzki.bgm_app.mapper;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.to.BookTo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void shouldMapEntityToDto(){
        // given
        final Integer expectedId = 77;
        final String expectedTitle = "Latarnik";
        final float expectedRate = 6.0F;
        final String expectedDescription = "O latarniku";
        final String expectedAuthor = "H. Sienkiewicz";
        Book bookEntity = new Book(expectedId, expectedTitle, expectedRate, expectedDescription, expectedAuthor);

        // when
        Object mappedBook = bookMapper.mapToDto(bookEntity);
        BookTo castedBook = (BookTo) mappedBook;

        // then
        assertEquals(BookTo.class, mappedBook.getClass());
        assertEquals(expectedId, castedBook.getId());
        assertEquals(expectedTitle, castedBook.getTitle());
        assertEquals(expectedRate, castedBook.getRate(), 0.001);
        assertEquals(expectedDescription, castedBook.getDescription());
        assertEquals(expectedAuthor, castedBook.getAuthor());

    }

    @Test
    public void shouldMapDtoToEntity(){
        // given
        final Integer expectedId = 33;
        final String expectedTitle = "W Pustyni i w puszczy";
        final float expectedRate = 8.0F;
        final String expectedDescription = "Egipt, Sudan, Staś i Nel.";
        final String expectedAuthor = "H. Sienkiewicz";
        BookTo bookTo = new BookTo(expectedId, expectedTitle, expectedRate, expectedDescription, expectedAuthor);

        // when
        Object mappedBook = bookMapper.mapToEntity(bookTo);
        Book castedBook = (Book) mappedBook;

        // then
        assertEquals(Book.class, mappedBook.getClass());
        assertEquals(expectedId, castedBook.getId());
        assertEquals(expectedTitle, castedBook.getTitle());
        assertEquals(expectedRate, castedBook.getRate(), 0.001);
        assertEquals(expectedDescription, castedBook.getDescription());
        assertEquals(expectedAuthor, castedBook.getAuthor());

    }

    @Test
    public void shouldMapListOfEntitiesToListOfDtos(){
        // given
        int expectedListSize = 3;
        List<Book> listOfEntities = Arrays.asList(new Book[]{new Book(), null, new Book()});

        // when
        List<BookTo> mappedList = bookMapper.mapToDto(listOfEntities);

        // then
        assertNull(mappedList.get(1));
        assertEquals(BookTo.class, mappedList.get(0).getClass());
        assertEquals(BookTo.class, mappedList.get(2).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }

    @Test
    public void shouldMapListOfDtosToListOfEntities(){
        // given
        int expectedListSize = 4;
        List<BookTo> listOfDtos = Arrays.asList(new BookTo[]{new BookTo(), null, null, new BookTo()});

        // when
        List<Book> mappedList = bookMapper.mapToEntity(listOfDtos);

        // then
        assertNull(mappedList.get(1));
        assertNull(mappedList.get(2));
        assertEquals(Book.class, mappedList.get(0).getClass());
        assertEquals(Book.class, mappedList.get(3).getClass());
        assertEquals(expectedListSize, mappedList.size());

    }
}
