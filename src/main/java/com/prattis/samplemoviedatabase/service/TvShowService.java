package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.TvShow;

import java.util.List;

public interface TvShowService extends GeneralService<TvShow, Long> {
    
    /**
     * Get all associated tv shows of a person.
     *
     * @param id The ID of the person.
     * @return A set of Movie objects representing the tv shows associated to a person.
     */
    List<TvShow> findByPersonId(long id);
    
    /**
     * Calculate the total cost of a tv show based on the salaries of all contributors.
     *
     * @param id The ID of the tv show.
     * @return The total cost of the tv show project.
     */
    MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(long id);
    
}
