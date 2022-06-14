package com.futflamengo.machado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futflamengo.machado.domain.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
	
}
