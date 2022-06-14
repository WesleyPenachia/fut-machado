package com.futflamengo.machado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futflamengo.machado.domain.Pessoa;
import com.futflamengo.machado.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repo;
	
	public Pessoa buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
