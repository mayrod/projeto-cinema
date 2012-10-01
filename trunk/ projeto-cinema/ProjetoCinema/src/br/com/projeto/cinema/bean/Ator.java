package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATOR")
public class Ator implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "pkAtor")
	private Long pkAtor;
	
	@Column(name = "nome")
	private String nome;

	public Long getPkAtor() {
		return pkAtor;
	}

	public void setPkAtor(Long pkAtor) {
		this.pkAtor = pkAtor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}
