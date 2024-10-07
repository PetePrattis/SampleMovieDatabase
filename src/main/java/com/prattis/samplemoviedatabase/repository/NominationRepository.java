package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Long> {
}
