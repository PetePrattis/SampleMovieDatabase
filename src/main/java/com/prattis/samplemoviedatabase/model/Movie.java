package com.prattis.samplemoviedatabase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Movie extends Product {
	
	@Column(name = "production_budget")
	private BigDecimal productionBudget;
	
	@Column(name = "year_of_release")
	private int yearOfRelease;
}
