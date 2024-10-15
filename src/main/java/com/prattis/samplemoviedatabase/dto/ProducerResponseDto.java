package com.prattis.samplemoviedatabase.dto;

import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.Producer;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Data transfer object (DTO) representing the response for the get producer information.
 * Contains the producer ID, name, salary type, salary
 * and nominations, movies, tv shows that the producer is associated with.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProducerResponseDto {
	private long id;
	private String name;
	private SalaryType salaryType;
	private BigDecimal salary;
	private List<Movie> movies;
	private List<TvShow> tvShows;
	
	public static ProducerResponseDto createDto(Producer producer, List<Movie> movies, List<TvShow> tvShows) {
		return ProducerResponseDto.builder()
				.id(producer.getId())
				.name(producer.getName())
				.salaryType(producer.getSalaryType())
				.salary(producer.getSalary())
				.movies(movies)
				.tvShows(tvShows)
				.build();
	}
}
