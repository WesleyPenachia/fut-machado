package com.futflamengo.machado.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Apostas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataJogo;
	private String placar;
	
	@ManyToOne
	@JoinColumn(name="joador_id")
	@JsonManagedReference
	private Jogador jogador;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "apostas")
	private List<Pessoa> pessoa = new ArrayList<>();
	
	public Apostas() {
	}

	public Apostas(Integer id, LocalDate dataJogo, String placar, Jogador jogador) {
		super();
		this.id = id;
		this.dataJogo = dataJogo;
		this.placar = placar;
		this.jogador = jogador;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(LocalDate dataJogo) {
		this.dataJogo = dataJogo;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, placar);
	}
	
	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apostas other = (Apostas) obj;
		return Objects.equals(id, other.id) && Objects.equals(placar, other.placar);
	}
}
