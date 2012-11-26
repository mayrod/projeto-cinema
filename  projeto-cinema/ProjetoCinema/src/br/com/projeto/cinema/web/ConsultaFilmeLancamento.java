package br.com.projeto.cinema.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.AvaliacaoFilmeDAO;
import br.com.projeto.cinema.dao.ElencoDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;
import br.com.projeto.cinema.dao.base.UtilDAO;
import br.com.projeto.cinema.utils.Constantes;

@ManagedBean(name="cinicial")
public class ConsultaFilmeLancamento {
	
    private List<FilmeLancamento> filmesLancamento;
	private FilmeLancamento filmeLancamentoSelecionado;
	private Long pkFilme;
	private Boolean visibilidade;
	private Integer avaliacao;
	private String comentario;
	private String email;
	private String nome;
	private List<AvaliacaoFilme> avaliacoes;

	public List<FilmeLancamento> getFilmesLancamento() throws Exception{
		new FilmeLancamentoDAO().atualizarStatus();
		filmesLancamento = new FilmeLancamentoDAO().obterFilmeLancamento(Constantes.STATUS_ATIVO);
		
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
    		filmeLancamentoSelecionado = new FilmeLancamentoDAO().obterFilmeLancamento(pkFilme);
    		filmeLancamentoSelecionado.getFilme().setElenco(new ElencoDAO().obterElenco(filmeLancamentoSelecionado.getFilme().getPkFilme()));
    		avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmeLancamentoSelecionado.getFilme().getPkFilme());
    	}
    }

	public Long getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(Long pkFilme) {
		this.pkFilme = pkFilme;
	}
	
	public Boolean getVisibilidade() 
	{
		return filmeLancamentoSelecionado!=null;
	}

	public void setVisibilidade(Boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
			
	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void salvarAvaliacao() throws Exception
    {
		if(email!=null && !email.equals("") && nome!=null && !nome.equals(""))
		{
			if(filmeLancamentoSelecionado==null)
			{
				filmeLancamentoSelecionado = new FilmeLancamentoDAO().obterFilmeLancamento(pkFilme);
			}
			
			AvaliacaoFilme ava = new AvaliacaoFilme();
			
			ava.setFilme(filmeLancamentoSelecionado.getFilme());
			ava.setAvaliacao(avaliacao);
			ava.setEmail(email);
			ava.setNome(nome);
			ava.setComentario(comentario);
			
			ava = new AvaliacaoFilmeDAO().save(ava);
			new UtilDAO().obterMediaAvaliacoes(filmeLancamentoSelecionado.getFilme());
			
			if(ava!=null)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensagem", "Avaliação Salva com Sucesso!"));  
				avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmeLancamentoSelecionado.getFilme().getPkFilme());
				avaliacao = 5;
				email = "";
				nome = "";
				comentario = "";
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensagem", "Digite seu Nome e E-mail!"));  
		}
    }

	public List<AvaliacaoFilme> getAvaliacoes() 
	{
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFilme> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
}
