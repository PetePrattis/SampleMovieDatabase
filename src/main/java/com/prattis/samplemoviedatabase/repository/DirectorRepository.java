package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
