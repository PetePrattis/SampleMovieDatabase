package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.NominationResultId;

import java.util.List;

public interface NominationResultService extends GeneralService<NominationResult, NominationResultId> {
    
    List<NominationResult> findByActorId(Long actorId);
}
