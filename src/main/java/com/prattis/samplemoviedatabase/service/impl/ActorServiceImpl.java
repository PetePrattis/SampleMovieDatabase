package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.dto.BestActorResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.repository.ActorRepository;
import com.prattis.samplemoviedatabase.repository.NominationResultRepository;
import com.prattis.samplemoviedatabase.service.ActorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.prattis.samplemoviedatabase.model.enums.NominationResultType.WON;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final ActorRepository actorRepository;
	private final NominationResultRepository nominationResultRepository;
	
	@Override
	public Actor create(Actor object) {
		return actorRepository.save(object);
	}
	
	@Override
	public List<Actor> read() {
		return actorRepository.findAll();
	}
	
	@Override
	public Actor read(Long id) {
		return actorRepository.findById(id).orElse(null);
	}
	
	@Override
	public Actor update(Long id, Actor updatedObject) {
		Actor actor = read(id);
		if (actor != null) {
			actor.setName(updatedObject.getName());
			actor.setSalary(updatedObject.getSalary());
			actor.setSalaryType(updatedObject.getSalaryType());
			actorRepository.save(actor);
		}
		return actor;
	}
	
	@Override
	public Actor delete(Long id) {
		Actor actor = read(id);
		if (actor != null) {
			actorRepository.delete(actor);
		}
		return actor;
	}
	
	@Override
	public MovieDbApiResult<Set<BestActorResponseDto>> getBestActorWinnersForRange(long minYear, long maxYear) {
		try {
			Set<BestActorResponseDto> actorResponseDtos = new HashSet<>();
			List<Actor> actors = read();
			if (actors != null) {
				for (Actor actor : actors) {
					List<NominationResult> nominationResults = nominationResultRepository.findByActorId(actor.getId());
					for (NominationResult nominationResult : nominationResults) {
						if (nominationResult.getNominationResultType().equals(WON) &&
								nominationResult.getNomination().getNominationYear() <= maxYear &&
								nominationResult.getNomination().getNominationYear() >= minYear) {
							actorResponseDtos.add(BestActorResponseDto.createDto(actor));
						}
					}
				}
				logger.info("The winner actors are {} ", actorResponseDtos);
				return MovieDbApiResult.<Set<BestActorResponseDto>>builder()
						.data(actorResponseDtos)
						.message("OK")
						.statusCode(200)
						.build();
			} else {
				logger.info("Sorry, no winners found");
				return MovieDbApiResult.<Set<BestActorResponseDto>>builder()
						.message("Bad Request")
						.statusCode(400)
						.build();
			}
		} catch (Exception e) {
			logger.info("Error occurred");
			return MovieDbApiResult.<Set<BestActorResponseDto>>builder()
					.message("Error occurred" + e.getMessage())
					.statusCode(500)
					.build();
		}
	}
	
	@Override
	public MovieDbApiResult<Set<BestActorResponseDto>> getNominatedActorNotWinners(long numberOfNominations) {
		return null;
	}
}
