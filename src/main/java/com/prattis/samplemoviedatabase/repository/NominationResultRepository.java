package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.NominationResult;
import com.prattis.samplemoviedatabase.model.NominationResultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NominationResultRepository extends JpaRepository<NominationResult, NominationResultId> {
    
    @Query("""
            select distinct nr
            from NominationResult nr
            where nr.nominationResultId.actorId = :actorId
            """)
    List<NominationResult> findByActorId(Long actorId);
}
