package com.twu.biblioteca;


public class startUp {
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.init();
        bibliotecaApp.welcomeMsg();
        bibliotecaApp.login();
        bibliotecaApp.mainMenu();
        bibliotecaApp.exec();
    }
}
