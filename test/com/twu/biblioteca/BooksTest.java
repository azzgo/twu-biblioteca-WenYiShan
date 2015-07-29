package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BooksTest {
    private Books books;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        books = Books.getInstance();
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testListBooks(){
        books.listBooks();
        String bookListMsg = "Margaret Thatcher: The Autobiography\n" + "Benjamin Franklin: An American Life\n" +
                "Steve Jobs: The Exclusive Biography\n";
        assertEquals(outStream.toString(), bookListMsg);
    }
}