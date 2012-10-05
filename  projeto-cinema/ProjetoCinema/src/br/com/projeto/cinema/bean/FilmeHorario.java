package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILMEHORARIO")
public class FilmeHorario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "pkFilmeHorario")
	private Long pkFilmeHorario;
	
	@Column(name = "tipoExibicao")
	private String tipoExibicao;
	
	@OneToOne @JoinColumn(name="fkHorario")
	private Horario horario;
	
	@OneToOne @JoinColumn(name="fkSala")
	private Sala sala;
	
	public Long getPkFilmeHorario() {
		return pkFilmeHorario;
	}

	public void setPkFilmeHorario(Long pkFilmeHorario) {
		this.pkFilmeHorario = pkFilmeHorario;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getTipoExibicao() {
		return tipoExibicao;
	}

	public void setTipoExibicao(String tipoExibicao) {
		this.tipoExibicao = tipoExibicao;
	}
	

}
