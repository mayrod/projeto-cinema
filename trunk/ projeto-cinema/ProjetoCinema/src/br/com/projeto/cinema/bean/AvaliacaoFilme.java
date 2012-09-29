package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIACAO_FILME")
public class AvaliacaoFilme implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkAvaliacaoFilme")
	private Long pkAvaliacaoFilme;
	
	@Column(name = "avaliacao")
	private Double avaliacao;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nome")
	private String nome;

	public Long getPkAvaliacaoFilme() {
		return pkAvaliacaoFilme;
	}

	public void setPkAvaliacaoFilme(Long pkAvaliacaoFilme) {
		this.pkAvaliacaoFilme = pkAvaliacaoFilme;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
