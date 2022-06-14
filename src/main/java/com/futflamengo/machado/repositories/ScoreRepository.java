package com.futflamengo.machado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futflamengo.machado.domain.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
	
}
