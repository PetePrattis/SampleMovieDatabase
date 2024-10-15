package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.ActorResponseDto;
import com.prattis.samplemoviedatabase.dto.BestActorResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.service.ActorService;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.NominationResultService;
import com.prattis.samplemoviedatabase.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/actor")
@AllArgsConstructor
public class ActorController {
	private final ActorService actorService;
	private final MovieService movieService;
	private final TvShowService tvShowService;
	private final NominationResultService nominationResultService;
	
	@PostMapping
	public Actor createActor(@RequestBody Actor actor) {
		return actorService.create(actor);
	}
	
	/**
	 * Retrieves a list of actors along with their associated movies, TV shows, and nomination results.
	 *
	 * @return A list of ActorResponseDto objects representing the actors along with their associated movies,
	 *         TV shows, and nomination results.
	 */
	@GetMapping
	public List<ActorResponseDto> getActor() {
		List<ActorResponseDto> actorResponseDtos = new ArrayList<>();
		List<Actor> actors = actorService.read();
		for (Actor actor : actors) {
			List<Movie> movies = movieService.findByPersonId(actor.getId());
			List<TvShow> tvShows = tvShowService.findByPersonId(actor.getId());
			List<NominationResult> nominationResults = nominationResultService.findByActorId(actor.getId());
			actorResponseDtos.add(ActorResponseDto.createDto(actor, nominationResults, movies, tvShows));
		}
		return actorResponseDtos;
	}
	
	@GetMapping("/{actorId}")
	public Actor getActor(@PathVariable long actorId) {
		List<Actor> actors = actorService.read();
		List<Actor> actorToFind = actors.stream().filter(a -> a.getId()==actorId).toList();
		if(actorToFind.isEmpty())
			throw new NullPointerException("The actorToFind LIST is empty.");
		return actorToFind.getFirst();
	}
	
	@PutMapping("/{actorId}")
	public Actor updateActor(@PathVariable long actorId, @RequestBody Actor newActor) {
		return actorService.update(actorId, newActor);
	}
	
	@DeleteMapping("/{actorId}")
	public Actor deleteActor(@PathVariable long actorId) {
		return actorService.delete(actorId);
	}
	
	/**
	 * Retrieves a list of actors that are best actor nomination winners for range.
	 *
	 * @return A list of BestActorResponseDto objects representing the actors.
	 */
	@GetMapping("/getBestActorWinnersForRange")
	public MovieDbApiResult<Set<BestActorResponseDto>> getBestActorWinnersForRange(@RequestParam("min_year") long minYear,
																				   @RequestParam("max_year") long maxYear) {
		return actorService.getBestActorWinnersForRange(minYear, maxYear);
	}
	
	@GetMapping("/{numberOfNominations}/getNominatedActorNotWinners")
	public MovieDbApiResult<Set<BestActorResponseDto>> getNominatedActorNotWinners(@PathVariable long numberOfNominations) {
		return actorService.getNominatedActorNotWinners(numberOfNominations);
	}
	
}
