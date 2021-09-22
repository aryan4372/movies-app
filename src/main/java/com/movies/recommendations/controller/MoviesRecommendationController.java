package com.movies.recommendations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.recommendations.model.Movies;
import com.movies.recommendations.service.MoviesRecommendationService;

@RestController
public class MoviesRecommendationController {

	@Autowired
	private MoviesRecommendationService moviesRecommendationService;

	@GetMapping("/list-of-languages")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<String> getListOfLanguages() {
		return moviesRecommendationService.getListOfLanguages();
	}

	@GetMapping("/list-of-languages-watchlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<String> getListOfLanguagesForWatchlist() {
		return moviesRecommendationService.getListOfLanguagesForWatchlist();
	}

	@GetMapping("/top-five-movies")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movies> getListOfTopMovies() {
		return moviesRecommendationService.getListOfTopMovies();
	}

	@PostMapping("/movies-by-language")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movies> getListOfMoviesByLanguage(@RequestBody Movies movie) {
		return moviesRecommendationService.getMoviesByLanguage(movie.getLanguage());
	}

	@PostMapping("/insert-into-movies")
	@CrossOrigin(origins = "http://localhost:4200")
	public Movies addANewMovieInList(@RequestBody Movies movie) {
		return moviesRecommendationService.addANewMovie(movie);
	}

	@PostMapping("/update-top-five")
	@CrossOrigin(origins = "http://localhost:4200")
	public int updateTopFiveList(@RequestBody Movies[] movie) {
		return moviesRecommendationService.updateTopFiveList(movie[0], movie[1]);
	}

	@PostMapping("/movies-in-watchlist-by-language")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movies> getListOfMoviesInWatchlistByLanguage(@RequestBody Movies movie) {
		return moviesRecommendationService.getMoviesInWatchListByLanguage(movie.getLanguage());
	}

	@PostMapping("/watched-from-watchlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public int watchedAMovieFromWatchlist(@RequestBody Movies movie) {
		return moviesRecommendationService.watchedAMovieFromWatchlist(movie);
	}
	
	@PostMapping("/remove-from-watchlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public int removeAMovieFromWatchlist(@RequestBody Movies movie) {
		return moviesRecommendationService.removeAMovieFromWatchlist(movie);
	}
	
	@PostMapping("/update-recommendation")
	@CrossOrigin(origins = "http://localhost:4200")
	public int updateRecommendedByMe(@RequestBody Movies movie) {
		return moviesRecommendationService.updateRecommendedByMe(movie);
	}

}
