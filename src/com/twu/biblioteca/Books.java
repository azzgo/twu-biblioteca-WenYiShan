package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Books {

    private static Books books;
    private ArrayList<HashMap<String, String>> booklist = new ArrayList<>();
    private ArrayList<HashMap<String, String>> checkbooks = new ArrayList<>();
    private Books(){
    }

    public static Books getInstance(){
        if(!(books instanceof Books)){
            books = new Books();
        }
        return books;
    }

    public void add(ArrayList<HashMap<String, String>> to, String bookName, String author, String publishYear){
        HashMap<String, String> book = new HashMap<>();
        book.put("bookName", bookName);
        book.put("author", author);
        book.put("publishYear", publishYear);
        to.add(book);
    }


    public void addBooktolist(String bookName, String author, String publishYear){
        add(booklist, bookName, author, publishYear);
    }

    public void addCheckedBook(String bookName, String author, String publshYear) {
        add(checkbooks, bookName, author, publshYear);
    }

    public void clearBooks() {
        booklist.clear();
        checkbooks.clear();
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


    public void returnBook(Scanner scanner) {
        String returnBookName = scanner.nextLine().trim();
        boolean successReturn = false;
        for(HashMap<String, String> book: checkbooks){
            if(book.get("bookName").equals(returnBookName)){
                checkbooks.remove(book);
                booklist.add(book);
                successReturn = true;
                break;
            }
        }
    }
}
