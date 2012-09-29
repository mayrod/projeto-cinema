package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILME_CATEGORIA")
public class FilmeCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkFilmeCategoria")
	private Long pkFilmeCategoria;
	
	@Column(name = "nome")
	private String nome;

	public Long getPkFilmeCategoria() {
		return pkFilmeCategoria;
	}

	public void setPkFilmeCategoria(Long pkFilmeCategoria) {
		this.pkFilmeCategoria = pkFilmeCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
