package com.futflamengo.machado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futflamengo.machado.domain.Apostas;

@Repository
public interface ApostaRepository extends JpaRepository<Apostas, Integer> {
	
}
