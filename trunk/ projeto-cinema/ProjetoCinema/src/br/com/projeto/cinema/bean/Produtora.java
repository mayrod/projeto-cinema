package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTORA")
public class Produtora implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkProdutora")
	private Long pkProdutora;
	
	@Column(name = "nome")
	private String nome;

	public Long getPkProdutora() {
		return pkProdutora;
	}

	public void setPkProdutora(Long pkProdutora) {
		this.pkProdutora = pkProdutora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
