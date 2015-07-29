package com.twu.biblioteca;

public class Books {
    private static Books books;
    private Books(){
    }

    public static Books getInstance(){
        if(!(books instanceof Books)){
            books = new Books();
        }
        return books;
    }

    public void listBooks(){
        String bookListMsg = "Margaret Thatcher: The Autobiography\n" + "Benjamin Franklin: An American Life\n" +
                "Steve Jobs: The Exclusive Biography";
        System.out.println(bookListMsg);
    }

}
