package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Books {

    private static Books books;
    private ArrayList<HashMap<String, String>> booklist = new ArrayList<>();
    private Books(){
    }

    public static Books getInstance(){
        if(!(books instanceof Books)){
            books = new Books();
        }
        return books;
    }

    public void add(String bookName,String author,String publishYear){
        HashMap<String, String> book = new HashMap<>();
        book.put("bookName", bookName);
        book.put("author", author);
        book.put("publishYear", publishYear);
        booklist.add(book);
    }

    public void clearBooks() {
        booklist.clear();
    }

    public void listBooks(){
        String bookListMsg = "";
        bookListMsg = joinBooklistToStirng(bookListMsg);
        System.out.print(bookListMsg);
    }

    public void bookDetail(){
        System.out.println("BookName, Author, Year");
        for(HashMap<String, String> book: booklist){
            System.out.println(book.get("bookName") + ", " +
                book.get("author") + ", " +
                book.get("publishYear"));
        }
    }

    private String joinBooklistToStirng(String bookListMsg) {
        for(int i = 0; i<booklist.size(); i++){
            HashMap<String, String> book = booklist.get(i);
            bookListMsg += (i+1) + "." + book.get("bookName") + '\n';
        }
        return bookListMsg;
    }
}
