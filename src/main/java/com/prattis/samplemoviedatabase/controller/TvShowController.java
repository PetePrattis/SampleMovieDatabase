package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv-show")
@AllArgsConstructor
public class TvShowController {
    
    private final TvShowService tvShowService;
    
    @PostMapping
    public TvShow createTvShow(@RequestBody TvShow tvShow) {
        return tvShowService.create(tvShow);
    }
    
    @GetMapping
    public List<TvShow> getTvShow() {
        return tvShowService.read();
    }
    
    @GetMapping("/{tvShowId}")
    public TvShow getTvShow(@PathVariable long tvShowId) {
        return tvShowService.read(tvShowId);
    }
    
    @PutMapping("/{tvShowId}")
    public TvShow updateTvShow(@PathVariable long tvShowId, @RequestBody TvShow newTvShow) {
        return tvShowService.update(tvShowId, newTvShow);
    }
    
    @DeleteMapping("/{tvShowId}")
    public TvShow deleteTvShow(@PathVariable long tvShowId) {
        return tvShowService.delete(tvShowId);
    }
    
    /**
     * Endpoint to calculate the total cost of a tv show project based on the salaries of all participants.
     *
     * @param tvShowId The ID of the tv show.
     * @return The total cost of the tv show and its id.
     */
    @GetMapping("/{tvShowId}/totalCost")
    public MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(@PathVariable long tvShowId) {
        // Call a method in the tv show service to calculate the total cost
        return tvShowService.calculateTotalCost(tvShowId);
    }
}
