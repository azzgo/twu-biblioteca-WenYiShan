package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class helperTools {
    public static ByteArrayOutputStream changeOutStream(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }
}
