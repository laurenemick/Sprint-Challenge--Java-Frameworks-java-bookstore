package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
public class BookServiceImplTest
{

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

//        List<Book> myList = bookService.findAll();
//        for (Book b : myList)
//        {
//            System.out.println(b.getBookid() + "" + b.getTitle() + "" + b.getSection()
//                .getSectionid());
//        }
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(5, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
        assertEquals("Flatterland", bookService.findBookById(26).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
        assertEquals("Flatterland", bookService.findBookById(100).getTitle());
    }

    @Test
    public void delete()
    {
        bookService.delete(27);
        assertEquals(4, bookService.findAll().size());
    }

    @Test
    public void save()
    {
        Section s1 = new Section("Fiction");
        s1.setSectionid(21);

        Book b1 = new Book("Lauren's book", "9780738206555", 2020, s1);
        b1 = bookService.save(b1);

        assertEquals("Lauren's book", b1.getTitle());
    }

//    @Test
//    public void update()
//    {
//    }
//
//    @Test
//    public void deleteAll()
//    {
//    }
}