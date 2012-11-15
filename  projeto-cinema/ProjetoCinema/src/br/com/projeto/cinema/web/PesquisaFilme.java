package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;
import br.com.projeto.cinema.dao.FilmeDAO;


@SessionScoped 
@ManagedBean(name="pesquisa")
public class PesquisaFilme {
	
	private FilmeCategoria categoria;
	private int pkCategoria;
	private List<Filme> filmes;
	private Filme filmeSelecionado;

	public FilmeCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(FilmeCategoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	public int getPkCategoria() {
		return pkCategoria;
	}

	public void setPkCategoria(int pkCategoria) {
		this.pkCategoria = pkCategoria;
	}
	
    public List<FilmeCategoria> getCategorias(){
		
		List<FilmeCategoria> categorias = new ArrayList<FilmeCategoria>();
		
		try {
		    categorias = new FilmeCategoriaDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categorias;
	}
    
    
    public void buscarFilme()
    {
    	categoria = new FilmeCategoriaDAO().findById(new Long(pkCategoria));
    	
    	if(categoria != null)
    	{
        	filmes = new FilmeDAO().getFilmes(categoria);
    	}
    	else
    	{
    		try {
				filmes = new FilmeDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

}
