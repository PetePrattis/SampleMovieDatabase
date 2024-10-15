package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.Nomination;
import com.prattis.samplemoviedatabase.repository.NominationRepository;
import com.prattis.samplemoviedatabase.service.NominationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NominationServiceImpl implements NominationService {
    
    private final NominationRepository nominationRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Nomination create(Nomination object) {
        return nominationRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Nomination> read() {
        return nominationRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Nomination read(Long id) {
        return nominationRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Nomination update(Long id, Nomination updatedObject) {
        Nomination nomination = read(id);
        if (nomination != null) {
            nomination.setNominationYear(updatedObject.getNominationYear());
            nomination.setGenre(updatedObject.getGenre());
            nominationRepository.save(nomination);
        }
        return nomination;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Nomination delete(Long id) {
        Nomination nomination = read(id);
        if (nomination != null) {
            nominationRepository.delete(nomination);
        }
        return nomination;
    }
}
