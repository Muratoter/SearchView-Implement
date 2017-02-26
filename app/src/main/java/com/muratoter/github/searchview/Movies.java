package com.muratoter.github.searchview;

/**
 * Created by Murat on 26.02.2017.
 */

public class Movies {
    private String MoviesName;
    private String MoviesDescription;

    public Movies(String moviesName, String moviesDescription) {
        MoviesName = moviesName;
        MoviesDescription = moviesDescription;
    }

    public String getMoviesName() {
        return MoviesName;
    }

    public void setMoviesName(String moviesName) {
        MoviesName = moviesName;
    }

    public String getMoviesDescription() {
        return MoviesDescription;
    }

    public void setMoviesDescription(String moviesDescription) {
        MoviesDescription = moviesDescription;
    }
}
