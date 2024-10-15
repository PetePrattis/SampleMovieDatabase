package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.Episode;
import com.prattis.samplemoviedatabase.repository.EpisodeRepository;
import com.prattis.samplemoviedatabase.service.EpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    
    private final EpisodeRepository episodeRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Episode create(Episode object) {
        return episodeRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Episode> read() {
        return episodeRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Episode read(Long id) {
        return episodeRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Episode update(Long id, Episode updatedObject) {
        Episode episode = read(id);
        if (episode != null) {
            episode.setMaximumProductionBudget(updatedObject.getMaximumProductionBudget());
            episode.setMinimumProductionBudget(updatedObject.getMinimumProductionBudget());
            episodeRepository.save(episode);
        }
        return episode;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Episode delete(Long id) {
        Episode episode = read(id);
        if (episode != null) {
            episodeRepository.delete(episode);
        }
        return episode;
    }
}
