package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkElenco")
	private Long pkElenco;
	
	@Column(name = "tipoPapel")
	private Integer tipoPapel;
    
	@ManyToOne @JoinColumn(name="fkAtor")
	private Ator ator; 
	
	@ManyToOne @JoinColumn(name="fkFilme")
	private Filme filme;
		
	public Long getPkElenco() {
		return pkElenco;
	}

	public void setPkElenco(Long pkElenco) {
		this.pkElenco = pkElenco;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public Integer getTipoPapel() {
		return tipoPapel;
	}

	public void setTipoPapel(Integer tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
