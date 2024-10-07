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
public class Episode extends BaseModel {
	
	@Column(name = "minimum_production_budget")
	private BigDecimal minimumProductionBudget;
	
	@Column(name = "maximum_production_budget")
	private BigDecimal maximumProductionBudget;
}
