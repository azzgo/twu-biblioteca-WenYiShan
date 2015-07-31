package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outStream;

    @Before
    public void setUp(){
        bibliotecaApp = new BibliotecaApp();
        outStream = helperTools.changeOutStream();
    }

    @Test
    public void testWelcomeMsg(){
        bibliotecaApp.WelcomeMsg();
        assertEquals(outStream.toString(), "Welcome to BiblioteApp System!\n");
    }

    @Test
    public void testMainMenuPrint(){
        bibliotecaApp.mainMenu();
        String outPut = outStream.toString();
        assertTrue(outPut.contains("L List Books"));
        assertTrue(outPut.contains("Q Quit the System"));
    }

    @Test
    public void testMenuHandler(){
        assertTrue(checkMenuItem('L', "List Books:"));
        assertTrue(checkMenuItem('Q', "Quit..."));
    }

    @Test
    public void testMenuHandlerOnInvaidOption(){
        bibliotecaApp.handlerMenuInput('!');
        assertTrue(outStream.toString().contains("Select a valid option!"));
    }

    @Test
    public void testIfCanInputOptionUntilQuit(){
        String inputOption = "1\nL\nQ\n1\n2\n";
        String[] shouldHaveStrings = {
                "Select a valid option!",
                "List Books:",
                "Quit...",
                "Select a valid option!",
                "Select a valid option!"
        };
        System.setIn(new ByteArrayInputStream(inputOption.getBytes()));
        bibliotecaApp.exec();
        String outPrintString = outStream.toString();
        checkIfAfterChoosedRespondIsRight(shouldHaveStrings, outPrintString);
    }

    private boolean checkMenuItem(char option, String shouldPrintMsg) {
        bibliotecaApp.handlerMenuInput(option);
        String outPut = outStream.toString();
        outStream.reset();
        return outPut.contains(shouldPrintMsg);
    }

    private void checkIfAfterChoosedRespondIsRight(String[] shouldHaveStrings, String outPrintString) {
        int[] resultInfoIndexes = helperTools.getresultInfoIndexes(shouldHaveStrings, outPrintString);
        assertNotEquals(resultInfoIndexes[0], -1);
        assertNotEquals(resultInfoIndexes[1], -1);
        assertNotEquals(resultInfoIndexes[2], -1);
        assertEquals(resultInfoIndexes[3], -1);
        assertEquals(resultInfoIndexes[4], -1);
    }
}
