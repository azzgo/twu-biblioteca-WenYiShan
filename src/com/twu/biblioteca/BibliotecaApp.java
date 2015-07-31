package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Books books;
    private boolean quitting = false;

    BibliotecaApp(){
        books = Books.getInstance();
    }

    public void welcomeMsg() {
        System.out.println("Welcome to BiblioteApp System!");
    }

    public void mainMenu() {
        System.out.println("There are Serval option You can choose to Manipulate This System:");
        System.out.println("L List Books");
        System.out.println("C Checkout Books");
        System.out.println("R Return Book");
        System.out.println("Q Quit the System");
        System.out.println("Your choose is(Regardless of the case):");
    }

    public void handlerMenuInput(char option, Scanner scanner) {
        switch (option){
            case 'L':
            case 'l':
                System.out.println("List Books:");
                books.listBooks();
                break;
            case 'C':
            case 'c':
                System.out.println("Checkout Books:");
                books.checkOutBooks(scanner);
                break;
            case 'R':
            case 'r':
                System.out.println("Return Book");
                books.returnBook(scanner);
                break;
            case 'Q':
            case 'q':
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
        while (scanner.hasNext()){
            String nextInput = scanner.next().trim();
            if(nextInput.length() > 1){
                showInvalidChooseErrorMsg();
            }else {
                handlerMenuInput(nextInput.charAt(0), scanner);
            }

            if(quitting != true){
                System.out.println("Your another choose is:");
            }else {
                break;
            }
        }
    }
}


