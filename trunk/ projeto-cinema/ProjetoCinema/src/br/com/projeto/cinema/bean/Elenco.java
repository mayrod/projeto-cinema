package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkElenco")
	private Long pkElenco;
	
	@Column(name = "tipoPapel")
	private String tipoPapel;
    
	@OneToMany @JoinTable(name="atores_elenco")
	private List<Ator> atores; 
	
	public Long getPkElenco() {
		return pkElenco;
	}

	public void setPkElenco(Long pkElenco) {
		this.pkElenco = pkElenco;
	}

	public String getTipoPapel() {
		return tipoPapel;
	}

	public void setTipoPapel(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	

}
