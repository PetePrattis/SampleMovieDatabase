package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
