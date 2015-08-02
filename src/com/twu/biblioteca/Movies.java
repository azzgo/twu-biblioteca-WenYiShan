package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Movies {
    private ArrayList<Map<String, String>> movielist;

    Movies(){
        movielist = new ArrayList<>();
    }

    public void add(String movieName, String year, String director, String rating) {
        HashMap<String, String> movie = new HashMap<>();
        movie.put("movieName", movieName);
        movie.put("year", year);
        movie.put("director", director);
        movie.put("rating", rating);
        movielist.add(movie);
    }

    public void listMovies() {
       for(int i=0; i<movielist.size(); i++){
           Map<String, String> movie = movielist.get(i);
           System.out.println("MovieName, Year, Director, Rating");
           System.out.println(
                   (i+1) + "." +
                   movie.get("movieName") + ", " +
                   movie.get("year") + ", " +
                   movie.get("director") + ", " +
                   movie.get("rating")
           );
       }
    }

    public void checkOutMovie(Scanner scanner) {
        while (scanner.hasNextInt()){
            int i = scanner.nextInt();
            if(i<0 || i> movielist.size() -1) {
                System.out.println("That Movie is not available.");
                System.out.println("Please select a different Movie or fix spelling error:");
                continue;
            }
            movielist.remove(i - 1);
            System.out.println("Thank you! Enjoy the Movie");
            break;
        }
    }
}
