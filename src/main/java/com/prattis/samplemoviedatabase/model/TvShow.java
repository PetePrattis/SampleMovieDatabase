package com.prattis.samplemoviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TvShow extends Product {
	
	@Column(name = "starting_year")
	private int startingYear;
	
	@Column(name = "ending_year")
	private int endingYear;
	
	@Column(name = "number_of_episodes")
	private int numberOfEpisodes;
	
	@OneToMany
	@JsonIgnore
	private Set<Episode> episodes;
}
