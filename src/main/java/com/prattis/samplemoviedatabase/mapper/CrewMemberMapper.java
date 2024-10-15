package com.prattis.samplemoviedatabase.mapper;

import com.prattis.samplemoviedatabase.dto.CrewMemberResponseDto;
import com.prattis.samplemoviedatabase.model.CrewMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CrewMemberMapper {
  @Mapping(source = "id", target = "id")
  CrewMemberResponseDto crewMemberToCrewMemberDto(CrewMember source);
}
