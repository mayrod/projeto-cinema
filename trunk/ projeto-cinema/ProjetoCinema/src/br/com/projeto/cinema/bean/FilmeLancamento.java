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
@Table(name = "FILMELANCAMENTO")
public class FilmeLancamento implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pkFilmeLancamento")
	private Long pkFilmeLancamento;
	
	@Column(name = "dataEstreia")
	private Date dataEstreia;
	
	@OneToOne @JoinColumn(name="fkFilme")
	private Filme filme;

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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public String toString() {
		return pkFilmeLancamento.toString();
	}
}
