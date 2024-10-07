package com.prattis.samplemoviedatabase.model;

import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseModel {
	
	private String name;
	
	@Column(name = "salary_type")
	private SalaryType salaryType;
	
	private BigDecimal salary;
}
