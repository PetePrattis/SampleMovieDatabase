package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.ProducerResponseDto;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.Producer;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.ProducerService;
import com.prattis.samplemoviedatabase.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producer")
@AllArgsConstructor
public class ProducerController {
    
    private final ProducerService producerService;
    private final MovieService movieService;
    private final TvShowService tvShowService;
    
    @PostMapping
    public Producer createProducer(@RequestBody Producer producer) {
        return producerService.create(producer);
    }
    
    /**
     * Retrieves a list of producer along with their associated movies, TV shows.
     *
     * @return A list of ProducerResponseDto objects representing the actors along with their associated movies,
     *         TV shows.
     */
    @GetMapping
    public List<ProducerResponseDto> getProducer() {
        List<ProducerResponseDto> producerResponseDtos = new ArrayList<>();
        List<Producer> producers = producerService.read();
        for (Producer producer : producers) {
            List<Movie> movies = movieService.findByPersonId(producer.getId());
            List<TvShow> tvShows = tvShowService.findByPersonId(producer.getId());
            producerResponseDtos.add(ProducerResponseDto.createDto(producer, movies, tvShows));
        }
        return producerResponseDtos;
    }
    
    @GetMapping("/{producerId}")
    public Producer getProducer(@PathVariable long producerId) {
        return producerService.read(producerId);
    }
    
    @PutMapping("/{producerId}")
    public Producer updateProducer(@PathVariable long producerId, @RequestBody Producer newProducer) {
        return producerService.update(producerId, newProducer);
    }
    
    @DeleteMapping("/{producerId}")
    public Producer deleteProducer(@PathVariable long producerId) {
        return producerService.delete(producerId);
    }
}
