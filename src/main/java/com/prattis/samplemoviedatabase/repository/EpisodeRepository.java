package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
