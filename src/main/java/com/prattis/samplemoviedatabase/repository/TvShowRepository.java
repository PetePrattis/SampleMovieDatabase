package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {
    
    @Query("""
            select distinct t
            from TvShow t
            join t.actors actor
            where actor.id = :actorId
            """)
    List<TvShow> findByActorId(Long actorId);
    
    @Query("""
            select distinct t
            from TvShow t
            join t.director director
            where director.id = :directorId
            """)
    List<TvShow> findByDirectorId(Long directorId);
    
    @Query("""
            select distinct t
            from TvShow t
            join t.producers producer
            where producer.id = :producerId
            """)
    List<TvShow> findByProducerId(Long producerId);
    
    @Query("""
            select distinct t
            from TvShow t
            join t.crewMembers crewMember
            where crewMember.id = :crewMemberId
            """)
    List<TvShow> findByCrewMemberId(Long crewMemberId);
}
