package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

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

    @Test
    public void testAfterCheckOutBookCheckedBookShouldnotInBookList(){
        String chooseBooks = "1\n1\n";
        System.setIn(new ByteArrayInputStream(chooseBooks.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.checkOutBooks(scanner);
        books.checkOutBooks(scanner);
        books.listBooks();
        String outPut = outStream.toString();
        assertFalse(outPut.contains("Margaret Thatcher"));
        assertFalse(outPut.contains("Benjamin Franklin"));
    }

    @Test
    public void testSuccessCheckBook(){
        String chooseBooks = "1\n";
        System.setIn(new ByteArrayInputStream(chooseBooks.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.checkOutBooks(scanner);
        assertEquals(outStream.toString(), "Thank you! Enjoy the book\n");
    }

    @Test
    public void testFailedCheckBookAndCanCheckAgain(){
        String chooseBooks = "-1\n1\n";
        System.setIn(new ByteArrayInputStream(chooseBooks.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.checkOutBooks(scanner);
        String outPut = outStream.toString();
        String[] shouldHaveStrings = {"That book is not available.", "Thank you! Enjoy the book"};
        int [] resultStringIndexes = helperTools.getresultInfoIndexes(shouldHaveStrings, outPut);
        assertNotEquals(resultStringIndexes[0], -1);
        assertNotEquals(resultStringIndexes[1], -1);
    }
}