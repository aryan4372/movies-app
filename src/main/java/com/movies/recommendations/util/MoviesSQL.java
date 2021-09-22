package com.movies.recommendations.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@PropertySource("classpath:sql.properties")
public class MoviesSQL {
	
	@Value("${sql.select.languages}")
	private String selectLanguages;
	
	@Value("${sql.select.languages.watchlist}")
	private String selectLanguagesForWatchlist;
	
	@Value("${sql.select.top.five}")
	private String selectTopFiveMovies;
	
	@Value("${sql.select.movie.by.language}")
	private String selectMoviesByLanguage;
	
	@Value("${sql.insert.movie.details}")
	private String addANewMovie;
	
	@Value("${sql.add.in.top.five}")
	private String addInTopFive;
	
	@Value("${sql.remove.from.top.five}")
	private String removeFromTopFive;
	
	@Value("${sql.select.movie.in.watchlist.by.language}")
	private String moviesInWatchListByLanguage;
	
	@Value("${sql.add.movie.from.watchlist}")
	private String watchedMovieFromWatchlist;
	
	@Value("${sql.remove.from.watchlist}")
	private String removeFromWatchlist;
	
	@Value("${sql.update.recommendation.by.me}")
	private String updateRecommendedByMe;


}
