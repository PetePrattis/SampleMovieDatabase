package com.prattis.samplemoviedatabase.dto;

import com.prattis.samplemoviedatabase.model.*;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Data transfer object (DTO) representing the response for the get director information.
 * Contains the director ID, name, salary type, salary
 * and movies, tv shows that the director is associated with.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DirectorResponseDto {
	private long id;
	private String name;
	private SalaryType salaryType;
	private BigDecimal salary;
	private List<Movie> movies;
	private List<TvShow> tvShows;
	
	public static DirectorResponseDto createDto(Director director, List<Movie> movies, List<TvShow> tvShows) {
		return DirectorResponseDto.builder()
				.id(director.getId())
				.name(director.getName())
				.salaryType(director.getSalaryType())
				.salary(director.getSalary())
				.movies(movies)
				.tvShows(tvShows)
				.build();
	}
}
