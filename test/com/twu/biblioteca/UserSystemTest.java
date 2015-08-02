package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserSystemTest {
    private UserSystem user;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp(){
        user = new UserSystem();
        outputStream = helperTools.changeOutStream();
    }



    @Test
    public void testUserLogin() {
        String libraryNumber = "xxx-xxxx\nxxx-xxxx";
        System.setIn(new ByteArrayInputStream(libraryNumber.getBytes()));
        assertFalse(user.isLoginStatus());
        user.login(new Scanner(System.in));
        assertTrue(user.isLoginStatus());
    }

    public void testRegisterAndUnRegisterCheckBookUser(){
        String libraryNumber = "xxx-xxxx\nxxx-xxxx";
        System.setIn(new ByteArrayInputStream(libraryNumber.getBytes()));
        user.login(new Scanner(System.in));
        assertNull(user.searchBookBrrower("Margaret Thatcher: The Autobiography"));
        user.registerCheckBook("Margaret Thatcher: The Autobiography");
        assertEquals("xxx-xxxx", user.searchBookBrrower("Margaret Thatcher: The Autobiography"));
        user.unRegisterCheckBook("Margaret Thatcher: The Autobiography");
        assertNull(user.searchBookBrrower("Margaret Thatcher: The Autobiography"));
    }

    @Test
    public void testUserInfo(){
        String libraryNumber = "xxx-xxxx\nxxx-xxxx";
        System.setIn(new ByteArrayInputStream(libraryNumber.getBytes()));
        user.login(new Scanner(System.in));
        user.info();
        assertTrue(outputStream.toString().contains("Lily, lili@q.com, 12399990000"));
    }

}

