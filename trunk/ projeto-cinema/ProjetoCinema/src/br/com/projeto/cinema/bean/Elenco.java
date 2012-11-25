package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projeto.cinema.utils.Constantes;

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
	
	private String papel;
	
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

	public String getPapel() 
	{
		return Constantes.getTipoPalelProtagonista(tipoPapel);
	}

	public void setPapel(String papel) 
	{
		papel = Constantes.getTipoPalelProtagonista(tipoPapel);
		this.papel = papel;
	}
}
