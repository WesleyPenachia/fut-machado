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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Placar implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataJogo;
	private String placar;
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name="PLACAR_SCORE",
		joinColumns = @JoinColumn(name="placar_id"),
		inverseJoinColumns = @JoinColumn(name="jogador_id")
			)
	private List<Jogador> jogador = new ArrayList<>();

	public Placar() {
	}

	public Placar(Integer id, LocalDate dataJogo, String placar) {
		super();
		this.id = id;
		this.dataJogo = dataJogo;
		this.placar = placar;
		
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

	public List<Jogador> getJogador() {
		return jogador;
	}

	public void setJogador(List<Jogador> jogador) {
		this.jogador = jogador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, jogador, placar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placar other = (Placar) obj;
		return Objects.equals(id, other.id) && Objects.equals(jogador, other.jogador)
				&& Objects.equals(placar, other.placar);
	}
}
