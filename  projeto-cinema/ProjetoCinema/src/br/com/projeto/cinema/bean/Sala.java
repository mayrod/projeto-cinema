package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.projeto.cinema.utils.Constantes;

@Entity
@Table(name = "SALA")
public class Sala implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkSala")
	private Long pkSala;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "tipoSala")
	private Integer tipoSala;

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

	public Integer getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(Integer tipoSala) {
		this.tipoSala = tipoSala;
	}

	@Override
	public String toString() 
	{
		if(tipoSala==Constantes.TIPO_SALA_2D) 		{ return "2D"; 		}
		else if(tipoSala==Constantes.TIPO_SALA_3D) 	{ return "3D"; 		}
		else 										{ return "2D e 3D"; }
	}
}
