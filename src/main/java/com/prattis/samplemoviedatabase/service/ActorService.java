package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.dto.BestActorResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.model.Actor;

import java.util.Set;

public interface ActorService extends GeneralService<Actor, Long> {
	MovieDbApiResult<Set<BestActorResponseDto>> getBestActorWinnersForRange(long minYear, long maxYear);
	
	MovieDbApiResult<Set<BestActorResponseDto>> getNominatedActorNotWinners(long numberOfNominations);
}
