package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        System.out.println("BookName, Author, Year");
        for(int i=0; i < booklist.size(); i++){
            HashMap<String, String> book = booklist.get(i);
            System.out.println(
                (i+1) + "." +
                book.get("bookName") + ", " +
                book.get("author") + ", " +
                book.get("publishYear")
            );
        }
    }

    public void checkOutBooks(Scanner scanner) {
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if(i<0 || i>booklist.size() -1) {
                System.out.println("That book is not available.");
                System.out.println("Please select a different book or fix spelling error:");
                continue;
            }
            booklist.remove(i-1);
            System.out.println("Thank you! Enjoy the book");
        }
    }
}
