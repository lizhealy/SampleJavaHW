package com.cofc.lizhealy.ingredient_matcher;

/**
 * Created by lizhealy on 4/14/16.
 */
import android.util.Log;

import java.util.ArrayList;

public class MovieSeeker extends GenericSeeker<Movie> {

    private static final String MOVIE_SEARCH_PATH = "Movie.search/";

    public ArrayList<Movie> find(String query) {
        ArrayList<Movie> moviesList = retrieveMoviesList(query);
        return moviesList;
    }

    public ArrayList<Movie> find(String query, int maxResults) {
        ArrayList<Movie> moviesList = retrieveMoviesList(query);
        return retrieveFirstResults(moviesList, maxResults);
    }

    private ArrayList<Movie> retrieveMoviesList(String query) {
        String url = constructSearchUrl(query);
        String response = httpRetriever.retrieve(url);
        Log.d(getClass().getSimpleName(), response);
        return xmlParser.parseMoviesResponse(response);
    }

    @Override
    public String retrieveSearchMethodPath() {
        return MOVIE_SEARCH_PATH;
    }

}