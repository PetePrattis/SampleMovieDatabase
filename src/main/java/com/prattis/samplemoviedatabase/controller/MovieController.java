package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.dto.TotalCostResponseDto;
import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.NominationResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    
    private final MovieService movieService;
    private final NominationResultService nominationResultService;
    
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }
    
    @GetMapping
    public List<Movie> getMovie() {
        return movieService.read();
    }
    
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable long movieId) {
        return movieService.read(movieId);
    }
    
    @PutMapping("/{movieId}")
    public Movie updateMovie(@PathVariable long movieId, @RequestBody Movie newMovie) {
        return movieService.update(movieId, newMovie);
    }
    
    @DeleteMapping("/{movieId}")
    public Movie deleteMovie(@PathVariable long movieId) {
        return movieService.delete(movieId);
    }
    
    /**
     * Endpoint to calculate the total cost of a movie project based on the salaries of all participants.
     *
     * @param movieId The ID of the movie.
     * @return The total cost of the movie and its id.
     */
    @GetMapping("/{movieId}/totalCost")
    public MovieDbApiResult<TotalCostResponseDto> calculateTotalCost(@PathVariable long movieId) {
        // Call a method in the movie service to calculate the total cost
        return movieService.calculateTotalCost(movieId);
    }
    
    @GetMapping("/with-at-least-nominated-actors")
    public List<Movie> getMoviesWithAtLeastNominatedActors(@RequestParam("amount") int amount) {
        List<NominationResult> nominationResults = nominationResultService.read();
        List<Movie> movies = movieService.read();
        List<Movie> moviesWithAtLeastNominatedActors = new ArrayList<>();
        for (Movie movie : movies) {
            List<Actor> movieActors = movie.getActors();
            int nominatedActors = 0;
            for (Actor actor : movieActors) {
                if (!nominationResults.stream().filter(nom -> nom.getActor().equals(actor)).toList().isEmpty())
                    ++nominatedActors;
            }
            if (nominatedActors >= amount)
                moviesWithAtLeastNominatedActors.add(movie);
        }
        return moviesWithAtLeastNominatedActors;
    }
    
    
}
