package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.model.Episode;
import com.prattis.samplemoviedatabase.service.EpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
@AllArgsConstructor
public class EpisodeController {
    
    private final EpisodeService episodeService;
    
    @PostMapping
    public Episode createEpisode(@RequestBody Episode episode) {
        return episodeService.create(episode);
    }
    
    @GetMapping
    public List<Episode> getEpisode() {
        return episodeService.read();
    }
    
    @GetMapping("/{episodeId}")
    public Episode getEpisode(@PathVariable long episodeId) {
        return episodeService.read(episodeId);
    }
    
    @PutMapping("/{episodeId}")
    public Episode updateEpisode(@PathVariable long episodeId, @RequestBody Episode newEpisode) {
        return episodeService.update(episodeId, newEpisode);
    }
    
    @DeleteMapping("/{episodeId}")
    public Episode deleteEpisode(@PathVariable long episodeId) {
        return episodeService.delete(episodeId);
    }
}
