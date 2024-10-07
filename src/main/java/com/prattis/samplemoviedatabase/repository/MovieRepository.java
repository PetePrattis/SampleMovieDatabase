package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    @Query("""
            select distinct m
            from Movie m
            join m.actors actor
            where actor.id = :actorId
            """)
//    @Query(value = "SELECT m.* FROM MOVIES m " +
//            "JOIN MOVIE_ACTORS ma ON m.id = ma.movie_id " +
//            "WHERE ma.actor_id = :actorId",
//            nativeQuery = true)
    List<Movie> findByActorId(Long actorId);
    
    @Query("""
            select distinct m
            from Movie m
            join m.director director
            where director.id = :directorId
            """)
    List<Movie> findByDirectorId(Long directorId);
    
    @Query("""
            select distinct m
            from Movie m
            join m.producers producer
            where producer.id = :producerId
            """)
    List<Movie> findByProducerId(Long producerId);
    
    @Query("""
            select distinct m
            from Movie m
            join m.crewMembers crewMember
            where crewMember.id = :crewMemberId
            """)
    List<Movie> findByCrewMemberId(Long crewMemberId);
    
}
