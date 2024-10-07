package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {
}
