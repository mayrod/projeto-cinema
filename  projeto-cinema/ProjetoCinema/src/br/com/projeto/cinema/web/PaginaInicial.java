package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.FilmeCartazDAO;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;

@ManagedBean(name="inicial")
public class PaginaInicial {
	
	private List<FilmeCartaz> filmesCartaz;
	private List<FilmeLancamento> filmesLancamento;
	private List<FilmePromocao> filmesPromocao;
	
	public List<FilmeCartaz> getFilmesCartaz(){
			
		 filmesCartaz = new ArrayList<FilmeCartaz>();
			
			try {
				filmesCartaz = new FilmeCartazDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filmesCartaz;
	}
	
	public void setFilmesPromocao(List<FilmePromocao> filmesPromocao) {
		this.filmesPromocao = filmesPromocao;
	}

	public List<FilmePromocao> getFilmesPromocao(){
		
		 filmesPromocao = new ArrayList<FilmePromocao>();
			
			try {
				filmesPromocao = new FilmePromocaoDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filmesPromocao;
		}
	
	public List<FilmeLancamento> getFilmesLancamento(){
		
		 filmesLancamento = new ArrayList<FilmeLancamento>();
			
			try {
				filmesLancamento = new FilmeLancamentoDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filmesLancamento;
		}





	public void setFilmesLancamento(List<FilmeLancamento> filmesLancamento) {
		this.filmesLancamento = filmesLancamento;
	}

	public void setFilmesCartaz(List<FilmeCartaz> filmesCartaz) {
		this.filmesCartaz = filmesCartaz;
	}
	    

}
