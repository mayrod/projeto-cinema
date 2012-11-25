package br.com.projeto.cinema.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.FilmeCartazDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;
import br.com.projeto.cinema.dao.base.UtilDAO;
import br.com.projeto.cinema.utils.Constantes;

@ManagedBean(name="inicial")
public class PaginaInicial {
	
	private List<FilmeCartaz> filmesCartaz;
	private List<FilmeLancamento> filmesLancamento;
	private List<FilmePromocao> filmesPromocao;
	private FilmeCartaz filmeCartazSelecionado;
	private FilmePromocao filmePromocaoSelecionado;
	private FilmeLancamento filmeLancamentoSelecionado;
	private Integer avaliacaoGeral;
	
	public List<FilmeCartaz> getFilmesCartaz() throws Exception
	{
		new FilmeCartazDAO().atualizarStatus();
		filmesCartaz = new FilmeCartazDAO().obterTodos();
		
		return filmesCartaz;
	}

	public List<FilmePromocao> getFilmesPromocao() throws Exception
	{
		new FilmePromocaoDAO().atualizarStatus();
		filmesPromocao = new FilmePromocaoDAO().obterTodos();
		
		return filmesPromocao;
	}
	
	public List<FilmeLancamento> getFilmesLancamento() throws Exception
	{
		new FilmeLancamentoDAO().atualizarStatus();
		filmesLancamento = new FilmeLancamentoDAO().obterFilmeLancamento(Constantes.STATUS_ATIVO);
		
		return filmesLancamento;
	}

	public void setFilmesLancamento(List<FilmeLancamento> filmesLancamento) {
		this.filmesLancamento = filmesLancamento;
	}

	public void setFilmesCartaz(List<FilmeCartaz> filmesCartaz) {
		this.filmesCartaz = filmesCartaz;
	}
	
	public void setFilmesPromocao(List<FilmePromocao> filmesPromocao) {
		this.filmesPromocao = filmesPromocao;
	}
	
	
	public FilmeCartaz getFilmeCartazSelecionado() {
		if(filmeCartazSelecionado != null){
			obterMediaAvaliacaoFilme();
		}
		return filmeCartazSelecionado;
	}

	public void setFilmeCartazSelecionado(FilmeCartaz filmeCartaz) {
		this.filmeCartazSelecionado = filmeCartaz;
	}


	public FilmePromocao getFilmePromocaoSelecionado() {
		if(filmePromocaoSelecionado != null){
			obterMediaAvaliacaoFilme();
		}
		return filmePromocaoSelecionado;
	}


	public void setFilmePromocaoSelecionado(FilmePromocao filmePromocaoSelecionado) {
		this.filmePromocaoSelecionado = filmePromocaoSelecionado;
	}


	public FilmeLancamento getFilmeLancamentoSelecionado() {
		return filmeLancamentoSelecionado;
	}


	public void setFilmeLancamentoSelecionado(
			FilmeLancamento filmeLancamentoSelecionado) {
		this.filmeLancamentoSelecionado = filmeLancamentoSelecionado;
	}
	
	private void obterMediaAvaliacaoFilme(){
		
		Long pkFilmeSelecionado = null;
		
		if(filmeCartazSelecionado!=null){ pkFilmeSelecionado = filmeCartazSelecionado.getFilme().getPkFilme(); }
		else if(filmeLancamentoSelecionado!=null) { pkFilmeSelecionado = filmeLancamentoSelecionado.getFilme().getPkFilme(); }
		else if(filmePromocaoSelecionado!=null) {  pkFilmeSelecionado = filmePromocaoSelecionado.getFilme().getPkFilme();  }
		
		double mediaAvaliacao = new UtilDAO().obterMediaAvaliacoes(pkFilmeSelecionado);
		avaliacaoGeral = (int) Math.ceil(mediaAvaliacao);
	}
	
	public void buscarFilme()
    {
    	filmeLancamentoSelecionado = filmesLancamento.get(1);
    }

	public void setAvaliacaoGeral(Integer avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}

	public Integer getAvaliacaoGeral() {
		return avaliacaoGeral;
	}

}
