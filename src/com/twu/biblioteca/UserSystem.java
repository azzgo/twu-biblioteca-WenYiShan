package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSystem {
    private boolean loginStatus;
    private String userLibraryNumber;
    private ArrayList<Map<String, String>> lendBookInfoList;
    private Map<String, String> userInfo;

    UserSystem(){
        this.loginStatus = false;
        lendBookInfoList = new ArrayList<>();
        userInfo = new HashMap<>();
        userInfo.put("name", "Lily");
        userInfo.put("email", "lili@q.com");
        userInfo.put("phone", "12399990000");
    }

    public boolean isLoginStatus() {
        return this.loginStatus;
    }

    public void login(Scanner scanner) {
        System.out.println("Please intput your LibraryNumber:");
        while (scanner.hasNextLine()){
            String libraryNumber = scanner.nextLine();
            if(libraryNumber.isEmpty()) continue;
            if(!libraryNumber.matches("^\\w{3}-\\w{4}$")){
                System.out.println("illegal Library Number Format!");
                System.out.println("Please input a different Number or fix spelling error:");
            }
            //fake verify library number
            if(!libraryNumber.equals("xxx-xxxx")){
                System.out.println("illegal Library Number!");
                System.out.println("Please input a different Number or fix spelling error:");
            }else {
                System.out.println("Please input Your Password:");
                String libraryPassword = scanner.nextLine();
                if(!libraryPassword.equals("xxx-xxxx")){
                    System.out.println("illegal Library Password!");
                    System.out.println("Please input a different Number or fix spelling error!");
                    System.out.println("Please intput your LibraryNumber again:");
                }else{
                    System.out.println("Login Success!");
                    this.loginStatus = true;
                    this.userLibraryNumber = libraryNumber;
                    break;
                }
            }
        }

    }

    public String searchBookBrrower(String BookName) {
        for(Map<String, String> lendBook: lendBookInfoList){
            if(lendBook.containsKey(BookName)){
                return lendBook.get(BookName);
            }
        }
        return null;
    }

    public void registerCheckBook(String BookName) {
        HashMap<String, String> lendBook = new HashMap<>();
        lendBook.put(BookName, this.userLibraryNumber);
        lendBookInfoList.add(lendBook);
        System.out.println("RegisterBook Successful!");
    }

    public void unRegisterCheckBook(String BookName){
        for(Map book: lendBookInfoList){
            if(book.containsKey(BookName)){
                lendBookInfoList.remove(book);
                System.out.println("unRegisterCheckBook Successful!");
                return;
            }
        }
        System.out.println("unRegisterCheckBook failel");
    }

    public void info() {
        System.out.println("LibraryNumber, Name, Email, Phone");
        System.out.println(this.userLibraryNumber + ", " +
                userInfo.get("name") + ", " +
                userInfo.get("email") + ", " +
                userInfo.get("phone"));
    }
}
