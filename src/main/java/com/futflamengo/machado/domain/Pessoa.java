package com.futflamengo.machado.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.futflamengo.machado.domain.enums.Perfil;

@Entity
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Column(unique = true)
	private String email;
	private String senha;
	
	@Column(unique = true)
	private String telefone;
	
	protected Integer perfis;
	
	protected LocalDate dataCriacao = LocalDate.now();
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name="PESSOA_APOSTA",
		joinColumns = @JoinColumn(name="pessoa_id"),
		inverseJoinColumns = @JoinColumn(name="aposta_id")
			)
	private List<Apostas> apostas = new ArrayList<>();
	
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name="PESSOA_SCORE",
		joinColumns = @JoinColumn(name="pessoa_id"),
		inverseJoinColumns = @JoinColumn(name="score_id")
			)
	private List<Score> score = new ArrayList<>();

	public Pessoa() {
		addPerfil(Perfil.USUARIO);
	}

	public Pessoa(Integer id, String nome, String email, String senha, String telefone, Perfil perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.perfis = perfis.getId();
		this.dataCriacao = LocalDate.now();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Perfil getPerfis() {
		return Perfil.toEnum(perfis);
	}

	public void addPerfil(Perfil perfil) {
		this.perfis = perfil.getId();
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Apostas> getApostas() {
		return apostas;
	}

	public void setApostas(List<Apostas> apostas) {
		this.apostas = apostas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, telefone);
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id) && Objects.equals(telefone, other.telefone);
	}
}
