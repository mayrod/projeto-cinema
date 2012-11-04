package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILMECARTAZ")
public class FilmeCartaz implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "pkFilmeCartaz")
	private Long pkFilmeCartaz;
	
	@Column(name = "dataInicio")
	private Date dataInicio;
	
	@Column(name = "dataTermino")
	private Date dataTermino;
	
	@OneToOne @JoinColumn(name="fkFilme")
	private Filme filme;

	public Long getPkFilmeCartaz() {
		return pkFilmeCartaz;
	}

	public void setPkFilmeCartaz(Long pkFilmeCartaz) {
		this.pkFilmeCartaz = pkFilmeCartaz;
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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public String toString() {
		return pkFilmeCartaz.toString();
	}
}
