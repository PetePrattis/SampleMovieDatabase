package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.Person;
import com.prattis.samplemoviedatabase.model.Product;
import com.prattis.samplemoviedatabase.service.PersonService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person create(Person object) {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Person> read() {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person read(Long id) {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person update(Long id, Person updatedObject) {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Person delete(Long id) {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Person> getAllContributors(long id, Product product) {
		if (product != null) {
			
			// Add actors
			Set<Person> contributors = new HashSet<>(product.getActors());
			
			// Add director
			contributors.add(product.getDirector());
			
			// Add producers
			contributors.addAll(product.getProducers());
			
			// Add crew members
			contributors.addAll(product.getCrewMembers());
			logger.info("Got all contributors for the product with id {}", id);
			return contributors;
		}
		logger.info("The product with id {} does not exist", id);
		return null;
	}
	
}
