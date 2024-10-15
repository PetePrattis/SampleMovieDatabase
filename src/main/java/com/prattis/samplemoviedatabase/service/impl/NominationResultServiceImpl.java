package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.NominationResultId;
import com.prattis.samplemoviedatabase.repository.NominationResultRepository;
import com.prattis.samplemoviedatabase.service.NominationResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NominationResultServiceImpl implements NominationResultService {
    
    private final NominationResultRepository nominationResultRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NominationResult create(NominationResult object) {
        return nominationResultRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NominationResult> read() {
        return nominationResultRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NominationResult read(NominationResultId id) {
        return nominationResultRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NominationResult update(NominationResultId id, NominationResult updatedObject) {
        NominationResult nominationResult = read(id);
        if (nominationResult != null) {
            nominationResult.setNominationResultType(updatedObject.getNominationResultType());
            nominationResultRepository.save(nominationResult);
        }
        return nominationResult;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NominationResult delete(NominationResultId id) {
        NominationResult nominationResult = read(id);
        if (nominationResult != null) {
            nominationResultRepository.delete(nominationResult);
        }
        return nominationResult;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<NominationResult> findByActorId(Long actorId) {
        return nominationResultRepository.findByActorId(actorId);
    }
}
