package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.model.Nomination;
import com.prattis.samplemoviedatabase.service.NominationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nomination")
@AllArgsConstructor
public class NominationController {
    
    private final NominationService nominationService;
    
    @PostMapping
    public Nomination createNomination(@RequestBody Nomination nomination) {
        return nominationService.create(nomination);
    }
    
    @GetMapping
    public List<Nomination> getNomination() {
        return nominationService.read();
    }
    
    @GetMapping("/{nominationId}")
    public Nomination getNomination(@PathVariable long nominationId) {
        return nominationService.read(nominationId);
    }
    
    @PutMapping("/{nominationId}")
    public Nomination updateNomination(@PathVariable long nominationId, @RequestBody Nomination newNomination) {
        return nominationService.update(nominationId, newNomination);
    }
    
    @DeleteMapping("/{nominationId}")
    public Nomination deleteNomination(@PathVariable long nominationId) {
        return nominationService.delete(nominationId);
    }
}
