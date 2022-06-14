package com.futflamengo.machado.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonBackReference
	@OneToMany(mappedBy = "jogador")
	private List<Apostas> aposta = new ArrayList<>();

	@JsonBackReference
	@ManyToMany(mappedBy = "jogador")
	List<Placar> placar = new ArrayList<>();
	

	public void setPlacar(List<Placar> placar) {
		this.placar = placar;
	}

	public Jogador() {
	}

	public Jogador(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Apostas> getAposta() {
		return aposta;
	}

	public void setAposta(List<Apostas> aposta) {
		this.aposta = aposta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<Placar> getPlacar() {
		return placar;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}
	
}
