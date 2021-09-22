package com.movies.recommendations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class MovieRecommendationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationsApplication.class, args);
	}

}
