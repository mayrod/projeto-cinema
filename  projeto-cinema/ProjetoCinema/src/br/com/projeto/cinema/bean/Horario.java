package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkHorario")
	private Long pkHorario;
	
	@Column(name = "horario")
	private String horario;
	
	@Column(name = "diaSemana")
	private Date diaSemana;

	public Long getPkHorario() {
		return pkHorario;
	}

	public void setPkHorario(Long pkHorario) {
		this.pkHorario = pkHorario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Date diaSemana) {
		this.diaSemana = diaSemana;
	}

}
