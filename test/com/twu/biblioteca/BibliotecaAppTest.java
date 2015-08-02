package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

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
        bibliotecaApp.welcomeMsg();
        assertEquals(outStream.toString(), "Welcome to BiblioteApp System!\n");
    }

    @Test
    public void testMainMenuPrint(){
        bibliotecaApp.mainMenu();
        String outPut = outStream.toString();
        assertTrue(outPut.contains("1 List Books"));
        assertTrue(outPut.contains("2 List Movies"));
        assertTrue(outPut.contains("3 Checkout Book"));
        assertTrue(outPut.contains("4 Checkout Movie"));
        assertTrue(outPut.contains("5 Return Book"));
        assertTrue(outPut.contains("6 Look UserInfo"));
        assertTrue(outPut.contains("7 MainMenu"));
        assertTrue(outPut.contains("0 Quit the System"));
    }

    @Test
    public void testMenuHandler(){
        assertTrue(checkMenuItem(1, "List Books:"));
        assertTrue(checkMenuItem(2, "List Movies:"));
        assertTrue(checkMenuItem(3, "Checkout Books(Please input the number in listBook):"));
        assertTrue(checkMenuItem(4, "Checkout Movies(Please input the number in listBook):"));
        assertTrue(checkMenuItem(5, "Return Book(Please input the BookName):"));
        assertTrue(checkMenuItem(6, "Your User Info is:"));
        assertTrue(checkMenuItem(7, "Show MainMenu"));
        assertTrue(checkMenuItem(0, "Quit..."));
    }

    @Test
    public void testMenuHandlerOnInvaidOption(){
        bibliotecaApp.handlerMenuInput('!', null);
        assertTrue(outStream.toString().contains("Select a valid option!"));
    }

    @Test
    public void testIfCanInputOptionUntilQuit(){
        String inputOption = "-1\n1\n0\n-1\n-1\n";
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

    private boolean checkMenuItem(int option, String shouldPrintMsg) {
        bibliotecaApp.handlerMenuInput(option, new Scanner(System.in));
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
