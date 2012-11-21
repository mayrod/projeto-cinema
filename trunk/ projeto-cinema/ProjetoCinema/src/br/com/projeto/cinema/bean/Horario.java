package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "pkHorario")
	private Long pkHorario;
	
	@Column(name = "horario")
	private String horario;
	
	@Column(name = "diaSemana")
	private int diaSemana;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "extensoDiaSemana")
	private String extensoDiaSemana;

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

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() 
	{
		switch (diaSemana) 
		{
			case 1: return "Domingo"; 
			case 2: return "Segunda-Feira";
			case 3: return "Terça-Feira";
			case 4: return "Quarta-Feira";
			case 5: return "Quinta-Feira";
			case 6: return "Sexta-Feira";
			case 7: return "Sábado";
			default:
				break;
		}
		return "";
	}

	public String getExtensoDiaSemana() {
		return extensoDiaSemana;
	}

	public void setExtensoDiaSemana(String extensoDiaSemana) {
		this.extensoDiaSemana = extensoDiaSemana;
	}
}
