package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.DirectorResponseDto;
import com.prattis.samplemoviedatabase.model.Director;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.service.DirectorService;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/director")
@AllArgsConstructor
public class DirectorController {
    
    private final DirectorService directorService;
    private final MovieService movieService;
    private final TvShowService tvShowService;
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.create(director);
    }
    
    /**
     * Retrieves a list of directors along with their associated movies and TV shows.
     *
     * @return A list of DirectorResponseDto objects representing the directors along with their associated movies and TV shows.
     */
    @GetMapping
    public List<DirectorResponseDto> getDirector() {
        List<DirectorResponseDto> directorResponseDtos = new ArrayList<>();
        List<Director> directors = directorService.read();
        for(Director director : directors) {
            List<Movie> movies = movieService.findByPersonId(director.getId());
            List<TvShow> tvShows = tvShowService.findByPersonId(director.getId());
            directorResponseDtos.add(DirectorResponseDto.createDto(director, movies, tvShows));
        }
        return directorResponseDtos;
    }
    
    @GetMapping("/{directorId}")
    public Director getDirector(@PathVariable long directorId) {
        return directorService.read(directorId);
    }
    
    @PutMapping("/{directorId}")
    public Director updateDirector(@PathVariable long directorId, @RequestBody Director newDirector) {
        return directorService.update(directorId, newDirector);
    }
    
    @DeleteMapping("/{directorId}")
    public Director deleteDirector(@PathVariable long directorId) {
        return directorService.delete(directorId);
    }
}
