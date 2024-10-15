package com.prattis.samplemoviedatabase.service;

import com.prattis.samplemoviedatabase.dto.CrewMemberResponseDto;
import com.prattis.samplemoviedatabase.dto.MovieDbApiResult;
import com.prattis.samplemoviedatabase.model.CrewMember;

public interface CrewMemberService extends GeneralService<CrewMember, Long> {
  MovieDbApiResult<CrewMemberResponseDto> readCrewMemberResponseDto(long crewMemberId);
}
