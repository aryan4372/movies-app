package com.movies.recommendations.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.movies.recommendations.model.Movies;
import com.movies.recommendations.util.MoviesSQL;

@Component
public class MoviesDaoImpl implements MoviesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private MoviesSQL moviesSQL;

	@Override
	public List<String> returnListOfLanguages() {
		String sql = moviesSQL.getSelectLanguages();
		List<Movies> moviesList = jdbcTemplate.query(sql, new Object[] {}, new MoviesMapperLanguages());
		List<String> languagesList = new ArrayList<String>();
		moviesList.stream().forEach(e -> {
			languagesList.add(e.getLanguage());
		});
		return languagesList;
	}

	@Override
	public List<Movies> returnListOfTopMovies() {
		String sql = moviesSQL.getSelectTopFiveMovies();
		return jdbcTemplate.query(sql, new Object[] {}, new MoviesMapper());
	}

	@Override
	public List<Movies> returnMoviesByLanguage(String language) {
		String sql = moviesSQL.getSelectMoviesByLanguage();
		return jdbcTemplate.query(sql, new Object[] { language }, new MoviesMapper());
	}

	@Override
	public Movies addMovie(Movies movie) {
		String sql = moviesSQL.getAddANewMovie();
		int success = jdbcTemplate.update(sql,
				new Object[] { movie.getName(), movie.getImage_path(), movie.getLanguage(), movie.getImdb_link(),
						movie.getWhere_to_watch(), movie.getRecommended_by_me(), movie.getRecommended_by_others(),
						movie.getIn_top_five() });
		if (success == 1) {
			return movie;
		}
		return null;
	}

	@Override
	public int removeFromTopFive(Movies movie) {
		String sql = moviesSQL.getRemoveFromTopFive();
		return jdbcTemplate.update(sql, new Object[] { movie.getName(), movie.getImdb_link() });

	}

	@Override
	public int addInTopFive(Movies movie) {
		String sql = moviesSQL.getAddInTopFive();
		return jdbcTemplate.update(sql, new Object[] { movie.getName(), movie.getImdb_link() });
	}

	@Override
	public List<Movies> returnMoviesInWatchlistByLanguage(String language) {
		String sql = moviesSQL.getMoviesInWatchListByLanguage();
		return jdbcTemplate.query(sql, new Object[] { language }, new MoviesMapper());
	}

	@Override
	public List<String> returnListOfLanguagesForWatchlist() {
		String sql = moviesSQL.getSelectLanguagesForWatchlist();
		List<Movies> moviesList = jdbcTemplate.query(sql, new Object[] {}, new MoviesMapperLanguages());
		List<String> languagesList = new ArrayList<String>();
		moviesList.stream().forEach(e -> {
			languagesList.add(e.getLanguage());
		});
		return languagesList;
	}

	@Override
	public int watchedAMovieFromWatchlist(Movies movie) {
		String sql = moviesSQL.getWatchedMovieFromWatchlist();
		return jdbcTemplate.update(sql, new Object[] { movie.getName(), movie.getImdb_link() });
	}

	@Override
	public int removeAMovieFromWatchlist(Movies movie) {
		String sql = moviesSQL.getRemoveFromWatchlist();
		return jdbcTemplate.update(sql, new Object[] { movie.getName(), movie.getImdb_link() });
	}

	@Override
	public int updateRecommendedByMe(Movies movie) {
		String sql = moviesSQL.getUpdateRecommendedByMe();
		return jdbcTemplate.update(sql , new Object [] {String.valueOf(movie.getRecommended_by_me()) , movie.getName() , movie.getImdb_link()});
	}

}

class MoviesMapperLanguages implements RowMapper<Movies> {
	public Movies mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movies movie = new Movies();
		if (rs.getString("language") != null) {
			movie.setLanguage(rs.getString("language"));
		}
		return movie;
	}
}

class MoviesMapper implements RowMapper<Movies> {
	public Movies mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movies movie = new Movies();
		if (rs.getString("language") != null) {
			movie.setLanguage(rs.getString("language"));
		}
		if (rs.getString("name") != null) {
			movie.setName(rs.getString("name"));
		}
		if (rs.getString("image_path") != null) {
			movie.setImage_path(rs.getString("image_path"));
		}
		if (rs.getString("imdb_link") != null) {
			movie.setImdb_link(rs.getString("imdb_link"));
		}
		if (rs.getString("where_to_watch") != null) {
			movie.setWhere_to_watch(rs.getString("where_to_watch"));
		}
		try
		{
		movie.setRecommended_by_me(Integer.parseInt(rs.getString("recommended_by_me")));
		}
		catch(NumberFormatException e)
		{}
		movie.setRecommended_by_others(rs.getBoolean("recommended_by_others"));
		movie.setIn_top_five(rs.getBoolean("in_top_five"));
		return movie;
	}
}
