package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO_EXIBICAO")
public class HorarioExibicao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkHorarioExibicao")
	private Long pkHorarioExibicao;
	
	@Column(name = "horario")
	private Date horario;

	public Long getPkHorarioExibicao() {
		return pkHorarioExibicao;
	}

	public void setPkHorarioExibicao(Long pkHorarioExibicao) {
		this.pkHorarioExibicao = pkHorarioExibicao;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

}
