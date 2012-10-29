package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.projeto.cinema.utils.Constantes;

@Entity
@Table(name = "SESSAO")
public class Sessao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "pkFilmeHorario")
	private Long pkSessao;
	
	@Column(name = "tipoExibicao")
	private int tipoExibicao;
	
	@OneToOne @JoinColumn(name="fkHorario")
	private Horario horario;
	
	@OneToOne @JoinColumn(name="fkSala")
	private Sala sala;
	
	@OneToOne @JoinColumn(name="fkFilme")
	private Filme filme;
	
	public Long getPkSessao() {
		return pkSessao;
	}

	public void setPkSessao(Long pkSessao) {
		this.pkSessao = pkSessao;
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

	public int getTipoExibicao() {
		return tipoExibicao;
	}

	public void setTipoExibicao(int tipoExibicao) {
		this.tipoExibicao = tipoExibicao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public String toString() 
	{
		if(tipoExibicao==Constantes.TIPO_SALA_2D) 		{ return "2D"; 		}
		else if(tipoExibicao==Constantes.TIPO_SALA_3D) 	{ return "3D"; 		}
		else 											{ return "2D e 3D"; }
	}
}
