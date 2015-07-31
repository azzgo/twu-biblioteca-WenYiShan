package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;


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
    public void testListBooksHaveAddedBooks(){
        books.listBooks();
        String outPut = outStream.toString();
        assertTrue(outPut.contains("Margaret Thatcher: The Autobiography"));
        assertTrue(outPut.contains("Benjamin Franklin: An American Life"));
        assertTrue(outPut.contains("Steve Jobs: The Exclusive Biography"));
    }

    @Test
    public void testListBooksHaveEachDetaiInfo(){
        books.listBooks();
        String outPut = outStream.toString();
        assertTrue(outPut.contains("BookName, Author, Year\n"));
        assertTrue(outPut.contains("Margaret Thatcher: The Autobiography, Margaret Thatcher, 2013\n"));
        assertTrue(outPut.contains("Benjamin Franklin: An American Life, Walter Isaacson, 2004\n"));
        assertTrue(outPut.contains("Steve Jobs: The Exclusive Biography, Walter Isaacson, 2014\n"));
    }

}