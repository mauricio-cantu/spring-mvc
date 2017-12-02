package com.example.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filmes database table.
 * 
 */
@Entity
@Table(name="filmes")
@NamedQuery(name="Filme.findAll", query="SELECT f FROM Filme f")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String diretor;

	private String genero;

	@Column(name="ano_lancamento")
	private Integer anoLancamento;

	private String titulo;

	public Filme() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiretor() {
		return this.diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}