package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILME_PROMOCAO")
public class FilmePromocao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pkFilmePromocao")
	private Long pkFilmePromocao;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "dataInicio")
	private Date dataInicio;
	
	@Column(name = "dataTermino")
	private Date dataTermino;
	
	@Column(name = "descricao")
	private String descricao;

	public Long getPkFilmePromocao() {
		return pkFilmePromocao;
	}

	public void setPkFilmePromocao(Long pkFilmePromocao) {
		this.pkFilmePromocao = pkFilmePromocao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
