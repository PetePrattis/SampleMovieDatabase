package com.prattis.samplemoviedatabase.dto;

import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ActorResponseDto {
	private long id;
	private String name;
	private SalaryType salaryType;
	private BigDecimal salary;
	private List<Movie> movies;
	private List<TvShow> tvShows;
	private List<NominationResult> nominationResults;
	
	public static ActorResponseDto createDto(Actor actor, List<NominationResult> nominationResults, List<Movie> movies, List<TvShow> tvShows) {
		return ActorResponseDto.builder()
				.id(actor.getId())
				.name(actor.getName())
				.salaryType(actor.getSalaryType())
				.salary(actor.getSalary())
				.movies(movies)
				.tvShows(tvShows)
				.nominationResults(nominationResults)
				.build();
	}
	
}
