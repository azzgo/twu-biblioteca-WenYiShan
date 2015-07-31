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
        books = new Books();
        books.addBooktolist("Margaret Thatcher: The Autobiography", "Margaret Thatcher", "2013");
        books.addBooktolist("Benjamin Franklin: An American Life", "Walter Isaacson", "2004");
        books.addBooktolist("Steve Jobs: The Exclusive Biography", "Walter Isaacson", "2014");
        books.addCheckedBook("Dear Life: Stories (Vintage International)", "Alice Munro", "2012");
        books.addCheckedBook("Airport (English Edition))", "Arthur Hailey", "2014");
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

    @Test
    public void testAfterReturnBookTheBookShouldInBookList(){
        books.listBooks();
        assertFalse(outStream.toString().contains("Airport (English Edition))"));
        outStream.reset();
        String returnBookName = "Airport (English Edition))";
        System.setIn(new ByteArrayInputStream(returnBookName.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.returnBook(scanner);
        books.listBooks();
        assertTrue(outStream.toString().contains("Airport (English Edition))"));
    }

    @Test
    public void testSuccessReturn(){
        String returnBookName = "Airport (English Edition))";
        System.setIn(new ByteArrayInputStream(returnBookName.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.returnBook(scanner);
        assertEquals(outStream.toString(), "Thank you for returning the book.\n");
    }

    @Test
    public void testFailedReturen(){
        String returnBookName = "Margaret Thatcher: The Autobiography\nAirport (English Edition))\n";
        System.setIn(new ByteArrayInputStream(returnBookName.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.returnBook(scanner);
        String outPut = outStream.toString();
        String[] shouldHaveStrings = {"That is not a valid book to return.", "Thank you for returning the book."};
        int [] resultStringIndexes = helperTools.getresultInfoIndexes(shouldHaveStrings, outPut);
        assertNotEquals(resultStringIndexes[0], -1);
        assertNotEquals(resultStringIndexes[1], -1);
    }
}