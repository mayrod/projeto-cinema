package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILME_LANCAMENTO")
public class FilmeLancamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkFilmeLancamento")
	private Long pkFilmeLancamento;
	
	@Column(name = "dataEstreia")
	private Date dataEstreia;

	public Long getPkFilmeLancamento() {
		return pkFilmeLancamento;
	}

	public void setPkFilmeLancamento(Long pkFilmeLancamento) {
		this.pkFilmeLancamento = pkFilmeLancamento;
	}

	public Date getDataEstreia() {
		return dataEstreia;
	}

	public void setDataEstreia(Date dataEstreia) {
		this.dataEstreia = dataEstreia;
	}
	
	

}
