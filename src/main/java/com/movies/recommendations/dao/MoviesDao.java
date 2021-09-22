package com.movies.recommendations.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.movies.recommendations.model.Movies;

@Component
public interface MoviesDao {
	
	public List<String> returnListOfLanguages();
	
	public List<String> returnListOfLanguagesForWatchlist();

	public List<Movies> returnListOfTopMovies();

	public List<Movies> returnMoviesByLanguage(String language);

	public Movies addMovie(Movies movie);
	
	public int removeFromTopFive(Movies movie);
	
	public int addInTopFive(Movies movie);
	
	public List<Movies> returnMoviesInWatchlistByLanguage(String language);

	public int watchedAMovieFromWatchlist(Movies movie);
	
	public int removeAMovieFromWatchlist(Movies movie);
	
	public int updateRecommendedByMe(Movies movie);
}
