package com.prattis.samplemoviedatabase.dto;

import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Data transfer object (DTO) representing the response for the best actor winner for range information.
 * Contains the actor ID, name, salary type, salary
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BestActorResponseDto {
	private long id;
	private String name;
	private SalaryType salaryType;
	private BigDecimal salary;
	
	public static BestActorResponseDto createDto(Actor actor) {
		return BestActorResponseDto.builder()
				.id(actor.getId())
				.name(actor.getName())
				.salaryType(actor.getSalaryType())
				.salary(actor.getSalary())
				.build();
	}
}
