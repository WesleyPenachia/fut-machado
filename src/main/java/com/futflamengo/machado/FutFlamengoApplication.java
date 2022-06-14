package com.futflamengo.machado;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.futflamengo.machado.domain.Apostas;
import com.futflamengo.machado.domain.Jogador;
import com.futflamengo.machado.domain.Pessoa;
import com.futflamengo.machado.domain.Placar;
import com.futflamengo.machado.domain.Score;
import com.futflamengo.machado.domain.enums.Perfil;
import com.futflamengo.machado.repositories.ApostaRepository;
import com.futflamengo.machado.repositories.JogadorRepository;
import com.futflamengo.machado.repositories.PessoaRepository;
import com.futflamengo.machado.repositories.PlacarRepository;
import com.futflamengo.machado.repositories.ScoreRepository;

@SpringBootApplication
public class FutFlamengoApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private PlacarRepository placarRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FutFlamengoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Jogador j1 = new Jogador(null, "Gabi");
		Jogador j2 = new Jogador(null, "Pedro");
		Jogador j3 = new Jogador(null, "Arrascaeta");
		
		Apostas ap1 = new Apostas(null, LocalDate.parse("2022-06-13"), "1x0",j1);
		Apostas ap2 = new Apostas(null, LocalDate.parse("2022-06-13"), "2x1",j3);
		Apostas ap3 = new Apostas(null, LocalDate.parse("2022-06-13"), "1x1",j1);
		Apostas ap4 = new Apostas(null, LocalDate.parse("2022-06-14"), "1x1",j2);
		
		Pessoa p1 = new Pessoa(null, "Wesley", "wesleyikiko@hotmail.com", "123", "35988515867", Perfil.ADMIN);
		Pessoa p2 = new Pessoa(null, "JOAO", "joao@hotmail.com", "123", "35988515866", Perfil.USUARIO);
		Pessoa p3 = new Pessoa(null, "Augusto", "Augusto@hotmail.com", "123", "35988515868", Perfil.USUARIO);
		Pessoa p4 = new Pessoa(null, "José Calos", "jcarlos@hotmail.com", "123", "35988515837", Perfil.ADMIN);

		Placar pl1 = new Placar(null, LocalDate.parse("2022-06-13"), "1x0");
		
		Score s1 = new Score(null, 2022, 0);
		
		j1.getAposta().addAll(Arrays.asList(ap1, ap3));
		j2.getAposta().addAll(Arrays.asList(ap4));
		j3.getAposta().addAll(Arrays.asList(ap2));
		
		ap1.getPessoa().addAll(Arrays.asList(p1,p4));
		ap2.getPessoa().addAll(Arrays.asList(p2));
		ap3.getPessoa().addAll(Arrays.asList(p3));
		ap4.getPessoa().addAll(Arrays.asList(p1));
		
		p1.getApostas().addAll(Arrays.asList(ap1, ap4));
		p2.getApostas().addAll(Arrays.asList(ap2));
		p3.getApostas().addAll(Arrays.asList(ap3));
		p4.getApostas().addAll(Arrays.asList(ap1));
		
		s1.getPessoas().addAll(Arrays.asList(p1, p2, p3, p4));
		
		p1.getScore().addAll(Arrays.asList(s1));
		p2.getScore().addAll(Arrays.asList(s1));
		p3.getScore().addAll(Arrays.asList(s1));
		p4.getScore().addAll(Arrays.asList(s1));
		
		pl1.getJogador().addAll(Arrays.asList(j3));
		j3.getPlacar().addAll(Arrays.asList(pl1));
		
		scoreRepository.saveAll(Arrays.asList(s1));
		jogadorRepository.saveAll(Arrays.asList(j1, j2, j3));
		apostaRepository.saveAll(Arrays.asList(ap1, ap2, ap3, ap4));
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		placarRepository.saveAll(Arrays.asList(pl1));
	}

	
	
}
