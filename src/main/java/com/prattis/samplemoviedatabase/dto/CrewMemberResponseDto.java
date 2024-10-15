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
 * Data transfer object (DTO) representing the response for the get crew member information.
 * Contains the crew member ID, name, salary type, salary
 * and nominations, movies, tv shows that the crew member is associated with.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CrewMemberResponseDto {
	private long id;
	private String name;
	private SalaryType salaryType;
	private BigDecimal salary;
	private List<Movie> movies;
	private List<TvShow> tvShows;
	private List<NominationResult> nominationResults;
	
	public static CrewMemberResponseDto createDto(CrewMember crewMember, List<Movie> movies, List<TvShow> tvShows) {
		return CrewMemberResponseDto.builder()
				.id(crewMember.getId())
				.name(crewMember.getName())
				.salaryType(crewMember.getSalaryType())
				.salary(crewMember.getSalary())
				.movies(movies)
				.tvShows(tvShows)
				.build();
	}
}
