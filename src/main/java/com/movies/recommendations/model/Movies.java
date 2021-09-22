package com.movies.recommendations.model;

import lombok.Data;

@Data
public class Movies {
	
	private String name;
	private String image_path;
	private String language;
	private String imdb_link;
	private String where_to_watch;
	private Integer recommended_by_me;
	private Boolean recommended_by_others;
	private Boolean in_top_five;
}
