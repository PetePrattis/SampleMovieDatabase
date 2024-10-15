package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.Person;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.model.enums.SalaryType;
import com.prattis.samplemoviedatabase.repository.TvShowRepository;
import com.prattis.samplemoviedatabase.service.PersonService;
import com.prattis.samplemoviedatabase.service.TvShowService;
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
public class TvShowServiceImpl implements TvShowService {
    
    private final TvShowRepository tvShowRepository;
    private final PersonService personService;
    
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * {@inheritDoc}
     */
    @Override
    public TvShow create(TvShow object) {
        return tvShowRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<TvShow> read() {
        return tvShowRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public TvShow read(Long id) {
        return tvShowRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public TvShow update(Long id, TvShow updatedObject) {
        TvShow tvShow = read(id);
        if (tvShow != null) {
            tvShow.setEndingYear(updatedObject.getEndingYear());
            tvShow.setEpisodes(updatedObject.getEpisodes());
            tvShow.setGenre(updatedObject.getGenre());
            tvShow.setActors(updatedObject.getActors());
            tvShow.setDirector(updatedObject.getDirector());
            tvShow.setStartingYear(updatedObject.getStartingYear());
            tvShow.setProducers(updatedObject.getProducers());
            tvShow.setTitle(updatedObject.getTitle());
            tvShowRepository.save(tvShow);
        }
        return tvShow;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public TvShow delete(Long id) {
        TvShow tvShow = read(id);
        if (tvShow != null) {
            tvShowRepository.delete(tvShow);
        }
        return tvShow;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<TvShow> findByPersonId(long personId) {
        List<TvShow> tvShows = new ArrayList<>();
        tvShows.addAll(tvShowRepository.findByActorId(personId));
        tvShows.addAll(tvShowRepository.findByDirectorId(personId));
        tvShows.addAll(tvShowRepository.findByProducerId(personId));
        tvShows.addAll(tvShowRepository.findByCrewMemberId(personId));
        
        return tvShows;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(long id) {
        try {
            TvShow tvShow = read(id);
            if (tvShow != null) {
                BigDecimal totalCost = BigDecimal.ZERO;
                Set<Person> contributors = personService.getAllContributors(id, tvShow);
                if (contributors != null) {
                    // Calculate total cost based on contributors' salaries and salary type
                    for (Person contributor : contributors) {
                        totalCost = totalCost.add(contributor.getSalaryType().equals(SalaryType.PER_PROJECT) ?
                                contributor.getSalary() : contributor.getSalary().multiply(BigDecimal.valueOf(tvShow.getEpisodes().size())));
                    }
                    logger.info("The total cost {} has been calculated successfully ", totalCost);
                    return MovieDbApiResult.<TotalCostResponseDto>builder()
                            .data(TotalCostResponseDto.createDto(tvShow, totalCost))
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
            logger.info("The tv show with id {} does not exist", id);
            return MovieDbApiResult.<TotalCostResponseDto>builder()
                    .message("Bad Request")
                    .statusCode(400)
                    .build();
        } catch (Exception e){
            logger.error("Error occurred for tv show with id {} does not exist: {}", id, e.getMessage());
            return MovieDbApiResult.<TotalCostResponseDto>builder()
                    .message("Error occurred: "+e.getMessage())
                    .statusCode(500)
                    .build();
        }
    }
}
