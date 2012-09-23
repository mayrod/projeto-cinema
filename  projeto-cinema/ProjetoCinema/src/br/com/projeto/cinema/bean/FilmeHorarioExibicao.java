package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO_FILME_EXIBICAO")
public class FilmeHorarioExibicao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pkHorarioFilmeExibicao")
	private Long pkHorarioFilmeExibicao;

	public Long getPkHorarioFilmeExibicao() {
		return pkHorarioFilmeExibicao;
	}

	public void setPkHorarioFilmeExibicao(Long pkHorarioFilmeExibicao) {
		this.pkHorarioFilmeExibicao = pkHorarioFilmeExibicao;
	}
	

}
