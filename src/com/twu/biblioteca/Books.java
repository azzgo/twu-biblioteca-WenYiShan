package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Books {

    private static Books books;
    private ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
    private ArrayList<HashMap<String, String>> checkedBooks = new ArrayList<>();

    public void add(ArrayList<HashMap<String, String>> to, String bookName, String author, String publishYear){
        HashMap<String, String> book = new HashMap<>();
        book.put("bookName", bookName);
        book.put("author", author);
        book.put("publishYear", publishYear);
        to.add(book);
    }


    public void addBooktolist(String bookName, String author, String publishYear){
        add(bookList, bookName, author, publishYear);
    }

    public void addCheckedBook(String bookName, String author, String publshYear) {
        add(checkedBooks, bookName, author, publshYear);
    }

    public void clearBooks() {
        bookList.clear();
        checkedBooks.clear();
    }


    public void listBooks(){
        System.out.println("BookName, Author, Year");
        for(int i=0; i < bookList.size(); i++){
            HashMap<String, String> book = bookList.get(i);
            System.out.println(
                (i+1) + "." +
                book.get("bookName") + ", " +
                book.get("author") + ", " +
                book.get("publishYear")
            );
        }
    }

    public void checkOutBooks(Scanner scanner) {
        while (scanner.hasNextInt()){
            int i = scanner.nextInt();
            if(i<0 || i> bookList.size() -1) {
                System.out.println("That book is not available.");
                System.out.println("Please select a different book or fix spelling error:");
                continue;
            }
            bookList.remove(i - 1);
            System.out.println("Thank you! Enjoy the book");
            break;
        }
    }

    public void returnBook(Scanner scanner) {
        while (scanner.hasNextLine()){
            String returnBookName = scanner.nextLine().trim();
            if(returnBookName.isEmpty()) continue;
            if(!checkIfBookIsChecked(returnBookName)){
                System.out.println("That is not a valid book to return.");
                System.out.println("Please input a different book or fix spelling error:");
                continue;
            }
            System.out.println("Thank you for returning the book.");
            break;
        }

    }

    private boolean checkIfBookIsChecked(String returnBookName) {
        boolean successReturn = false;
        for(HashMap<String, String> book: checkedBooks){
            if(book.get("bookName").equals(returnBookName)){
                checkedBooks.remove(book);
                bookList.add(book);
                successReturn = true;
                break;
            }
        }
        return successReturn;
    }
}
