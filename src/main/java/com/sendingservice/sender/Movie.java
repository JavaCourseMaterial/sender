package com.sendingservice.sender;


import java.util.Collection;



public class Movie {
    // Movie ID | Movie title | year Released | genre | runtime


    private long movieId;


    private String title;


    private String year;


    private String genre;


    private Long runtime; //expressed in minutes


   // private Collection reviews;



    public Movie() {
        //this.movieId = movieId;
        this.title = "Roger Rabbit";
        this.year = "2014";
        this.genre = "Documentary";
        this.runtime = 3L;
        //this.reviews = reviews;
    }

//    public long getMovieId() {
//        return movieId;
//    }
//    public void setMovieId(long movieId) {
//        this.movieId = movieId;
//    }

    public String getTitle() {
        return title;
    }


//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getYear() {
        return year;
    }

//    public void setYear(String year) {
//        this.year = year;
//    }

    public String getGenre() {
        return genre;
    }

//    public void setGenre(String genre) {
//        this.genre = genre;
//    }

    public Long getRuntime() {
        return runtime;
    }

//    public void setRuntime(Long runtime) {
//        this.runtime = runtime;
//    }

//    public Collection getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(Collection reviews) {
//        this.reviews = reviews;
//    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';
    }
}