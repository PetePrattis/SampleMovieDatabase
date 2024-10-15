package com.prattis.samplemoviedatabase.controller;

import com.prattis.samplemoviedatabase.dto.CrewMemberResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.model.CrewMember;
import com.prattis.samplemoviedatabase.model.Movie;
import com.prattis.samplemoviedatabase.model.TvShow;
import com.prattis.samplemoviedatabase.service.CrewMemberService;
import com.prattis.samplemoviedatabase.service.MovieService;
import com.prattis.samplemoviedatabase.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crew-member")
@AllArgsConstructor
public class CrewMemberController {
    
    private final CrewMemberService crewMemberService;
    private final MovieService movieService;
    private final TvShowService tvShowService;
    
    @PostMapping
    public CrewMember createCrewMember(@RequestBody CrewMember crewMember) {
        return crewMemberService.create(crewMember);
    }
    
    /**
     * Retrieves a list of crew members along with their associated movies, TV shows.
     *
     * @return A list of CrewMemberResponseDto objects representing the crew members along with their associated movies,
     *         TV shows.
     */
    @GetMapping
    public List<CrewMemberResponseDto> getCrewMember() {
        List<CrewMemberResponseDto> crewMemberResponseDtos = new ArrayList<>();
        List<CrewMember> crewMembers = crewMemberService.read();
        for (CrewMember crewMember : crewMembers) {
            List<Movie> movies = movieService.findByPersonId(crewMember.getId());
            List<TvShow> tvShows = tvShowService.findByPersonId(crewMember.getId());
            crewMemberResponseDtos.add(CrewMemberResponseDto.createDto(crewMember, movies, tvShows));
        }
        return crewMemberResponseDtos;
    }

    @GetMapping("/{crewMemberId}")
    public MovieDbApiResult<CrewMemberResponseDto> getCrewMemberTest(@PathVariable long crewMemberId) {
        return crewMemberService.readCrewMemberResponseDto(crewMemberId);
    }

    @PutMapping("/{crewMemberId}")
    public CrewMember updateCrewMember(@PathVariable long crewMemberId, @RequestBody CrewMember newCrewMember) {
        return crewMemberService.update(crewMemberId, newCrewMember);
    }
    
    @DeleteMapping("/{crewMemberId}")
    public CrewMember deleteCrewMember(@PathVariable long crewMemberId) {
        return crewMemberService.delete(crewMemberId);
    }
}
