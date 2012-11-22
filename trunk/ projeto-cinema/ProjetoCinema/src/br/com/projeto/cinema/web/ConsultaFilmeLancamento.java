package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;

@ManagedBean(name="cinicial")
public class ConsultaFilmeLancamento {
	
    private List<FilmeLancamento> filmesLancamento;
	private FilmeLancamento filmeLancamentoSelecionado;
	private AvaliacaoFilme avaliacao = new AvaliacaoFilme();
	private int pkFilme;
	
	public List<FilmeLancamento> getFilmesLancamento(){
		if(filmesLancamento==null)
		{
			filmesLancamento = new ArrayList<FilmeLancamento>();
			
			try {
				filmesLancamento = new FilmeLancamentoDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return filmesLancamento;
	}

	public void setFilmesLancamento(List<FilmeLancamento> filmesLancamento) {
		this.filmesLancamento = filmesLancamento;
	}


	public FilmeLancamento getFilmeLancamentoSelecionado() {
		return filmeLancamentoSelecionado;
	}


	public void setFilmeLancamentoSelecionado(
			FilmeLancamento filmeLancamentoSelecionado) {
		this.filmeLancamentoSelecionado = filmeLancamentoSelecionado;
	}
	

	public void buscarFilme()
    {
    	if(pkFilme != 0)
    	{
    		filmeLancamentoSelecionado = new FilmeLancamentoDAO().findById(new Long(pkFilme));
    	}
    }

	public int getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(int pkFilme) {
		this.pkFilme = pkFilme;
	}

}
