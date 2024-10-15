package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.Movie;

import java.util.List;

public interface MovieService extends GeneralService<Movie, Long> {
	
	/**
	 * Calculate the total cost of a movie based on the salaries of all contributors.
	 *
	 * @param id The ID of the movie.
	 * @return The total cost of the movie project.
	 */
	MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(long id);
	
	/**
	 * Get all associated movies of a person.
	 *
	 * @param id The ID of the person.
	 * @return A set of Movie objects representing the movies associated to a person.
	 */
	List<Movie> findByPersonId(long id);
	
}
