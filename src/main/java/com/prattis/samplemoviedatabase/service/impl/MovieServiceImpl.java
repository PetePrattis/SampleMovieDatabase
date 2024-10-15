package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.*;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import com.prattis.samplemoviedatabase.repository.MovieRepository;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.PersonService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository;
    private final PersonService personService;

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Movie create(Movie object) {
        return movieRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> read() {
        return movieRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Movie read(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Movie update(Long id, Movie updatedObject) {
        Movie movie = read(id);
        if (movie != null) {
            movie.setProductionBudget(updatedObject.getProductionBudget());
            movie.setActors(updatedObject.getActors());
            movie.setGenre(updatedObject.getGenre());
            movie.setDirector(updatedObject.getDirector());
            movie.setTitle(updatedObject.getTitle());
            movie.setYearOfRelease(updatedObject.getYearOfRelease());
            movie.setProducers(updatedObject.getProducers());
            movieRepository.save(movie);
        }
        return movie;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Movie delete(Long id) {
        Movie movie = read(id);
        if (movie != null) {
            movieRepository.delete(movie);
        }
        return movie;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(long id) {
        try {
            Movie movie = read(id);
            if (movie != null) {
                BigDecimal totalCost = BigDecimal.ZERO;
                Set<Person> contributors = personService.getAllContributors(id, movie);
                if (contributors != null) {
                    // Calculate total cost based on contributors' salaries and salary type
                    for (Person contributor : contributors) {
                        totalCost = totalCost.add(contributor.getSalaryType().equals(SalaryType.PER_PROJECT) ?
                                contributor.getSalary() : contributor.getSalary().multiply(BigDecimal.valueOf(20)));
                    }
                    logger.info("The total cost {} has been calculated successfully ", totalCost);
                    return MovieDbApiResult.<TotalCostResponseDto>builder()
                            .data(TotalCostResponseDto.createDto(movie, totalCost))
                            .message("OK")
                            .statusCode(200)
                            .build();
                } else {
                    // Unable to fetch contributors, return null
                    logger.info("There are no contributors");
                    return MovieDbApiResult.<TotalCostResponseDto>builder()
                            .message("Bad Request")
                            .statusCode(400)
                            .build();
                }
            }
            logger.info("The movie with id {} does not exist", id);
            return MovieDbApiResult.<TotalCostResponseDto>builder()
                    .message("Bad Request")
                    .statusCode(400)
                    .build();
        } catch (Exception e){
            logger.error("Error occurred for movie with id {} does not exist: {}", id, e.getMessage());
            return MovieDbApiResult.<TotalCostResponseDto>builder()
                    .message("Error occurred: "+e.getMessage())
                    .statusCode(500)
                    .build();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> findByPersonId(long personId) {
        List<Movie> movies = new ArrayList<>();
        movies.addAll(movieRepository.findByActorId(personId));
        movies.addAll(movieRepository.findByDirectorId(personId));
        movies.addAll(movieRepository.findByProducerId(personId));
        movies.addAll(movieRepository.findByCrewMemberId(personId));
        return movies;
    }
}
