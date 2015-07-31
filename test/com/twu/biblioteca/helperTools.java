package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class helperTools {
    public static ByteArrayOutputStream changeOutStream(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    public static  int[] getresultInfoIndexes(String[] shouldHaveStrings, String outPrintString) {
        int[] resultInfoIndexes = new int[shouldHaveStrings.length];
        for(int i=0; i< resultInfoIndexes.length; i++){
            resultInfoIndexes[i] = outPrintString.indexOf(shouldHaveStrings[i]);
            outPrintString = resultInfoIndexes[i] == -1? outPrintString : outPrintString.substring(resultInfoIndexes[i]);
        }
        return resultInfoIndexes;
    }
}
