package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRECO")
public class Preco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pkPreco")
	private Long pkPreco;
	
	@Column(name = "preco")
	private Double preco;

	public Long getPkPreco() {
		return pkPreco;
	}

	public void setPkPreco(Long pkPreco) {
		this.pkPreco = pkPreco;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
