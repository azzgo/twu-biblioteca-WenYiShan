package com.twu.biblioteca;

public class BibliotecaApp {
    private Books books;

    BibliotecaApp(){
        books = Books.getInstance();
    }

    public static void main(String[] args) {
        new BibliotecaApp().WelcomeMsg();
    }

    public void WelcomeMsg() {
        System.out.println("Welcome to BiblioteApp System!");
    }

    public void mainMenu() {
        System.out.println("There are Serval option You can choose to Manipulate This System:");
        System.out.println("L List Books");
        System.out.print("Your choose is: ");
    }

    public void handlerMenuInput(char option) {
        switch (option){
            case 'L':
                System.out.println("List Books:");
                books.listBooks();
                break;
        }
    }
}


