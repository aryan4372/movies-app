package com.movies.recommendations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.recommendations.dao.MoviesDao;
import com.movies.recommendations.model.Movies;

@Service
public class MoviesRecommendationService {

	@Autowired
	private MoviesDao moviesDAO;

	public List<String> getListOfLanguages() {
		return moviesDAO.returnListOfLanguages();
	}

	public List<String> getListOfLanguagesForWatchlist() {
		return moviesDAO.returnListOfLanguagesForWatchlist();
	}

	public List<Movies> getListOfTopMovies() {
		return moviesDAO.returnListOfTopMovies();
	}

	public List<Movies> getMoviesByLanguage(String language) {
		return moviesDAO.returnMoviesByLanguage(language);
	}

	public Movies addANewMovie(Movies movie) {
		return moviesDAO.addMovie(movie);
	}

	public int updateTopFiveList(Movies toBeAdded, Movies toBeRemoved) {
		int x = moviesDAO.removeFromTopFive(toBeRemoved);
		if (x == 1) {
			return moviesDAO.addInTopFive(toBeAdded);
		}
		return 0;
	}

	public List<Movies> getMoviesInWatchListByLanguage(String language) {
		return moviesDAO.returnMoviesInWatchlistByLanguage(language);
	}

	public int watchedAMovieFromWatchlist(Movies movie) {
		return moviesDAO.watchedAMovieFromWatchlist(movie);
	}

	public int removeAMovieFromWatchlist(Movies movie) {
		return moviesDAO.removeAMovieFromWatchlist(movie);
	}
	
	public int updateRecommendedByMe(Movies movie) {
		return moviesDAO.updateRecommendedByMe(movie);
	}

}
