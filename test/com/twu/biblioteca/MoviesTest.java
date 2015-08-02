package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class MoviesTest {
    private Movies movies;
    private ByteArrayOutputStream outStream;

    @Before
    public void setUp(){
        movies = new Movies();
        movies.add("Alistar Legrand", "2015", "Alistar Legrand", "unrated");
        movies.add("The In-Laws", "1979", "Arthur Hiller", "7.9");
        movies.add("True Stories", "1986", "David Byrne", "8.6");
        outStream = helperTools.changeOutStream();
    }

    @Test
    public void TestListMoviesHaveAddedMovies(){
        movies.listMovies();
        String outPut = outStream.toString();
        assertTrue(outPut.contains("Alistar Legrand, 2015, Alistar Legrand, unrated"));
        assertTrue(outPut.contains("The In-Laws, 1979, Arthur Hiller, 7.9"));
        assertTrue(outPut.contains("True Stories, 1986, David Byrne, 8.6"));
    }

    @Test
    public void TestAfterCheckedMovieIFStillInMovieList(){
        String choose = "1";
        System.setIn(new ByteArrayInputStream(choose.getBytes()));
        movies.checkOutMovie(new Scanner(System.in));
        movies.listMovies();
        assertFalse(outStream.toString().contains("Alistar Legrand"));
    }

}
