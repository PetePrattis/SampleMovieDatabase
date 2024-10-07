package com.prattis.samplemoviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {
	
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Director director;
	
	@ManyToMany
	@JsonIgnore
	private List<Actor> actors;
	
	@ManyToMany
	@JsonIgnore
	private List<Producer> producers;
	
	@ManyToMany
	@JsonIgnore
	private List<CrewMember> crewMembers;
	
	private String genre;
}
