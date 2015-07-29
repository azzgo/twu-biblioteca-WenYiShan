package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private PrintStream outPrint;

    @Before
    public void setUp(){
        bibliotecaApp = new BibliotecaApp();
        outPrint = new PrintStream(outStream);
        System.setOut(outPrint);
    }

    @Test
    public void testWelcomeMsg(){
        bibliotecaApp.WelcomeMsg();
        assertEquals(outStream.toString(), "Welcome to BiblioteApp System!\n");
    }
}
