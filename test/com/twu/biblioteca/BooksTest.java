package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;


public class BooksTest {
    private Books books;
    private ByteArrayOutputStream outStream;

    @Before
    public void setUp(){
        books = Books.getInstance();
        books.add("Margaret Thatcher: The Autobiography", "Margaret Thatcher", "2013");
        books.add("Benjamin Franklin: An American Life", "Walter Isaacson", "2004");
        books.add("Steve Jobs: The Exclusive Biography", "Walter Isaacson", "2014");
        outStream = helperTools.changeOutStream();
    }

    @After
    public void tearDown(){
        books.clearBooks();
    }

    @Test
    public void testListBooks(){
        books.listBooks();
        String bookListMsg = "1.Margaret Thatcher: The Autobiography\n" +
                "2.Benjamin Franklin: An American Life\n" +
                "3.Steve Jobs: The Exclusive Biography\n";
        assertEquals(outStream.toString(), bookListMsg);
    }

    @Test
    public void testBookDetail(){
        books.bookDetail();
        String bookinfo = "BookName, Author, Year\n" +
                "Margaret Thatcher: The Autobiography, " + "Margaret Thatcher, " + "2013\n" +
                "Benjamin Franklin: An American Life, " + "Walter Isaacson, " + "2004\n" +
                "Steve Jobs: The Exclusive Biography, " + "Walter Isaacson, " + "2014\n";
        assertEquals(outStream.toString(), bookinfo);
    }
}