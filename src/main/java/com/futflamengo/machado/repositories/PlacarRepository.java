package com.futflamengo.machado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futflamengo.machado.domain.Placar;

@Repository
public interface PlacarRepository extends JpaRepository<Placar, Integer> {
	
}
