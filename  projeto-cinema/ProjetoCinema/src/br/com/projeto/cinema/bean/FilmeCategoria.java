package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILMECATEGORIA")
public class FilmeCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkFilmeCategoria")
	private Long pkFilmeCategoria;
	
	@Column(name = "nome")
	private String nome;

	public Long getPkFilmeCategoria() {
		return pkFilmeCategoria;
	}

	public void setPkFilmeCategoria(Long pkFilmeCategoria) {
		this.pkFilmeCategoria = pkFilmeCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((pkFilmeCategoria == null) ? 0 : pkFilmeCategoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeCategoria other = (FilmeCategoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pkFilmeCategoria == null) {
			if (other.pkFilmeCategoria != null)
				return false;
		} else if (!pkFilmeCategoria.equals(other.pkFilmeCategoria))
			return false;
		return true;
	}
}
