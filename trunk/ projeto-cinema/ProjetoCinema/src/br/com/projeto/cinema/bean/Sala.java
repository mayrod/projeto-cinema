package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALA")
public class Sala implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pkSala")
	private Long pkSala;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "codigo")
	private String codigo;

	public Long getPkSala() {
		return pkSala;
	}

	public void setPkSala(Long pkSala) {
		this.pkSala = pkSala;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
