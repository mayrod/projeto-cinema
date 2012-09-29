package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkElenco")
	private Long pkElenco;
	
	@Column(name = "tipo")
	private String tipo;

	public Long getPkElenco() {
		return pkElenco;
	}

	public void setPkElenco(Long pkElenco) {
		this.pkElenco = pkElenco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
