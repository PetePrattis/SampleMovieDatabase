package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.dto.CrewMemberResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.mapper.CrewMemberMapper;
import com.prattis.samplemoviedatabase.model.CrewMember;
import com.prattis.samplemoviedatabase.repository.CrewMemberRepository;
import com.prattis.samplemoviedatabase.service.CrewMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CrewMemberServiceImpl implements CrewMemberService {
    
    private final CrewMemberRepository crewMemberRepository;
    private final CrewMemberMapper crewMemberMapper;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public CrewMember create(CrewMember object) {
        return crewMemberRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<CrewMember> read() {
        return crewMemberRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public CrewMember read(Long id) {
        return crewMemberRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public CrewMember update(Long id, CrewMember updatedObject) {
        CrewMember crewMember = read(id);
        if (crewMember != null) {
            crewMember.setName(updatedObject.getName());
            crewMember.setSalary(updatedObject.getSalary());
            crewMember.setSalaryType(updatedObject.getSalaryType());
            crewMemberRepository.save(crewMember);
        }
        return crewMember;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public CrewMember delete(Long id) {
        CrewMember crewMember = read(id);
        if (crewMember != null) {
            crewMemberRepository.delete(crewMember);
        }
        return crewMember;
    }

    @Override
    public MovieDbApiResult<CrewMemberResponseDto> readCrewMemberResponseDto(long crewMemberId) {
        try {
            var crewMember = read(crewMemberId);
            if (crewMember != null)
                return MovieDbApiResult.<CrewMemberResponseDto>builder()
                    .data(crewMemberMapper.crewMemberToCrewMemberDto(crewMember))
                    .message("OK")
                    .statusCode(200)
                    .build();
            return MovieDbApiResult.<CrewMemberResponseDto>builder()
                .message("Bad Request")
                .statusCode(400)
                .build();
        } catch (Exception e){
            return MovieDbApiResult.<CrewMemberResponseDto>builder()
                .message("Error occurred: "+e.getMessage())
                .statusCode(500)
                .build();
        }
    }

}
