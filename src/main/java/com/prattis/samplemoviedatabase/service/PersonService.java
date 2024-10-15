package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.model.Person;
import com.prattis.samplemoviedatabase.model.Product;

import java.util.Set;

public interface PersonService extends GeneralService<Person, Long>{
	
	/**
	 * Get all contributors (actors, director, producers, crew members) of a movie or tv show.
	 *
	 * @param id The ID of the movie or tv show and the Object of the product.
	 * @return A set of Person objects representing the contributors associated with the movie or tv show.
	 */
	Set<Person> getAllContributors(long id, Product product);
}
