package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.model.Actor;
import com.prattis.samplemoviedatabase.model.Nomination;
import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.NominationResultId;
import com.prattis.samplemoviedatabase.service.ActorService;
import com.prattis.samplemoviedatabase.service.NominationResultService;
import com.prattis.samplemoviedatabase.service.NominationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nomination-result")
@AllArgsConstructor
public class NominationResultController {
    
    private final ActorService actorService;
    private final NominationService nominationService;
    private final NominationResultService nominationResultService;
    
    @PostMapping
    public NominationResult createNominationResult(@RequestBody NominationResult nominationResult) {
        if ((actorService.read(nominationResult.getActor().getId()) != null)
                && (nominationService.read(nominationResult.getNomination().getId()) != null)
        )
            return nominationResultService.create(nominationResult);
        return null;
    }
    
    @GetMapping
    public List<NominationResult> getNominationResult() {
        return nominationResultService.read();
    }
    
    @GetMapping("/id")
    public NominationResult getNominationResult(@RequestParam("actor") long actorId,
                                                @RequestParam("nomination") long nominationId) {
        Actor actor = actorService.read(actorId);
        Nomination nomination = nominationService.read(nominationId);
        if ((actor != null) && (nomination != null)) {
            NominationResultId nominationResultId = new NominationResultId(actorId, nominationId);
            return nominationResultService.read(nominationResultId);
        }
        return null;
    }
    
    @PutMapping
    public NominationResult updateNominationResult(@RequestParam("actor") long actorId,
                                                   @RequestParam("nomination") long nominationId,
                                                   @RequestBody NominationResult newNominationResult) {
        Actor actor = actorService.read(actorId);
        Nomination nomination = nominationService.read(nominationId);
        if ((actor != null) && (nomination != null)) {
            NominationResultId nominationResultId = new NominationResultId(actorId, nominationId);
            NominationResult nominationResult = NominationResult.builder()
                    .nominationResultId(nominationResultId)
                    .actor(actor)
                    .nomination(nomination)
                    .nominationResultType(newNominationResult.getNominationResultType())
                    .build();
            return nominationResultService.update(nominationResultId, nominationResult);
        }
        return null;
    }
    
    @DeleteMapping
    public NominationResult deleteNominationResult(@RequestParam("actor") long actorId,
                                                   @RequestParam("nomination") long nominationId) {
        Actor actor = actorService.read(actorId);
        Nomination nomination = nominationService.read(nominationId);
        if ((actor != null) && (nomination != null)) {
            NominationResultId nominationResultId = new NominationResultId(actorId, nominationId);
            return nominationResultService.delete(nominationResultId);
        }
        return null;
    }
}
