package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Books books;
    private Movies movies;
    private UserSystem user;
    private boolean quitting = false;

    BibliotecaApp(){
        books =  new Books();
        movies = new Movies();
        user = new UserSystem();
    }

    public void init(){
        books.addBooktolist("Margaret Thatcher: The Autobiography", "Margaret Thatcher", "2013");
        books.addBooktolist("Benjamin Franklin: An American Life", "Walter Isaacson", "2004");
        books.addBooktolist("Steve Jobs: The Exclusive Biography", "Walter Isaacson", "2014");
        books.addCheckedBook("Dear Life: Stories (Vintage International)", "Alice Munro", "2012");
        books.addCheckedBook("Airport (English Edition))", "Arthur Hailey", "2014");
        movies.add("Alistar Legrand", "2015", "Alistar Legrand", "unrated");
        movies.add("The In-Laws", "1979", "Arthur Hiller", "7.9");
        movies.add("True Stories", "1986", "David Byrne", "8.6");
    }

    public void welcomeMsg() {
        System.out.println("Welcome to BiblioteApp System!");
    }

    public void mainMenu() {
        System.out.println("There are Serval option You can choose to Manipulate This System:");
        System.out.println("1 List Books");
        System.out.println("2 List Movies");
        System.out.println("3 Checkout Book");
        System.out.println("4 Checkout Movie");
        System.out.println("5 Return Book");
        System.out.println("6 Look UserInfo");
        System.out.println("7 MainMenu");
        System.out.println("0 Quit the System");
        System.out.println("Your choose is(Regardless of the case):");
    }

    public void handlerMenuInput(int option, Scanner scanner) {
        String bookName;
        switch (option){
            case 1:
                System.out.println("List Books:");
                books.listBooks();
                break;
            case 2:
                System.out.println("List Movies:");
                movies.listMovies();
                break;
            case 3:
                System.out.println("Checkout Books(Please input the number in listBook):");
                bookName = books.checkOutBooks(scanner);
                if(bookName != null){
                    user.registerCheckBook(bookName);
                }
                break;
            case 4:
                System.out.println("Checkout Movies(Please input the number in listBook):");
                movies.checkOutMovie(scanner);
                break;
            case 5:
                System.out.println("Return Book(Please input the BookName):");
                bookName = books.returnBook(scanner);
                if(bookName != null){
                    user.unRegisterCheckBook(bookName);
                }
                break;
            case 6:
                System.out.println("Your User Info is:");
                user.info();
                break;
            case 7:
                System.out.println("Show MainMenu");
                this.mainMenu();
                break;
            case 0:
                System.out.println("Quit...");
                quitting = true;
                break;
            default:
                showInvalidChooseErrorMsg();
        }
    }

    private void showInvalidChooseErrorMsg() {
        System.out.println("Select a valid option!");
    }

    public void exec(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int nextInput = scanner.nextInt();
            if(nextInput < 0 || nextInput > 7){
                showInvalidChooseErrorMsg();
            }else {
                handlerMenuInput(nextInput, scanner);
            }

            if(!quitting){
                System.out.println();
                System.out.println("Back to MainMenu!(You can input 7 to see MainMenu info Again)");
                System.out.println("Your another choose is:");
            }else {
                break;
            }
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You must Login Fist!");
        user.login(scanner);
    }
}


