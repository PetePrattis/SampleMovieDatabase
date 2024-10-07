package com.prattis.samplemoviedatabase.repository;

import com.prattis.samplemoviedatabase.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
