package br.com.projeto.cinema.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.AvaliacaoFilmeDAO;
import br.com.projeto.cinema.dao.FilmeCartazDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;
import br.com.projeto.cinema.utils.Constantes;

@ManagedBean(name="inicial")
public class PaginaInicial {
	
	private List<FilmeCartaz> filmesCartaz;
	private List<FilmeLancamento> filmesLancamento;
	private List<FilmePromocao> filmesPromocao;
	private FilmeCartaz filmeCartazSelecionado;
	private FilmePromocao filmePromocaoSelecionado;
	private FilmeLancamento filmeLancamentoSelecionado;
	private Integer avaliacaoGeral = 0;
	private AvaliacaoFilme avaliacao = new AvaliacaoFilme();
	
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
		return filmeCartazSelecionado;
	}

	public void setFilmeCartazSelecionado(FilmeCartaz filmeCartaz) {
		this.filmeCartazSelecionado = filmeCartaz;
	}


	public FilmePromocao getFilmePromocaoSelecionado() {
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

	public Integer getAvaliacaoGeral() 
	{
		avaliacaoGeral = 0;
		Filme filme = null;
		
		if(filmeCartazSelecionado!=null) { filme = filmeCartazSelecionado.getFilme(); }
		else if(filmeLancamentoSelecionado!=null) { filme = filmeLancamentoSelecionado.getFilme(); }
		else if(filmePromocaoSelecionado!=null) { filme = filmePromocaoSelecionado.getFilme(); }
		
		if(filme.getAvaliacaoFilme()!=null && filme.getAvaliacaoFilme().size()>0)
		{
			for(AvaliacaoFilme af : filme.getAvaliacaoFilme())
			{
				avaliacaoGeral += af.getAvaliacao();
			}
			avaliacaoGeral = avaliacaoGeral / filme.getAvaliacaoFilme().size();
		}
		
		return avaliacaoGeral;
	}

	public void setAvaliacaoGeral(Integer avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}

	public AvaliacaoFilme getAvaliacao() 
	{
		avaliacao = new AvaliacaoFilme(); 
		avaliacao.setAvaliacao(5);
		avaliacao.setEmail("");
		avaliacao.setNome("");
		avaliacao.setComentario("");
		avaliacaoGeral = 0;
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoFilme avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public void salvarAvaliacao()
    {
		Filme filme = null;
		
		if(filmeCartazSelecionado!=null) { filme = filmeCartazSelecionado.getFilme(); }
		else if(filmeLancamentoSelecionado!=null) { filme = filmeLancamentoSelecionado.getFilme(); }
		else if(filmePromocaoSelecionado!=null) { filme = filmePromocaoSelecionado.getFilme(); }
		
		avaliacao.setFilme(filme);
		new AvaliacaoFilmeDAO().save(avaliacao);
		avaliacao = new AvaliacaoFilme(); 
		avaliacao.setAvaliacao(5);
		avaliacao.setEmail("");
		avaliacao.setNome("");
		avaliacao.setComentario("");
    }
	

	public void buscarFilme()
    {
    	filmeLancamentoSelecionado = filmesLancamento.get(1);
    }
}
