package br.com.projeto.cinema.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.AvaliacaoFilmeDAO;
import br.com.projeto.cinema.dao.ElencoDAO;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;
import br.com.projeto.cinema.dao.base.UtilDAO;

@ManagedBean(name="fpromocao")
public class ConsultaFilmePromocao {
	
    private List<FilmePromocao> filmesPromocao;
	private FilmePromocao filmePromocaoSelecionado;
	private Long pkFilme;
	private Boolean visibilidade;
	private Integer avaliacao;
	private String comentario;
	private String email;
	private String nome;
	private List<AvaliacaoFilme> avaliacoes;
	
	public List<FilmePromocao> getFilmesPromocao() throws Exception {
		new FilmePromocaoDAO().atualizarStatus();
		filmesPromocao = new FilmePromocaoDAO().obterTodos();
		
		return filmesPromocao;
	}

	public void setFilmesPromocao(List<FilmePromocao> filmesPromocao) {
		this.filmesPromocao = filmesPromocao;
	}

	public FilmePromocao getFilmePromocaoSelecionado() {
		return filmePromocaoSelecionado;
	}

	public void setFilmePromocaoSelecionado(FilmePromocao filmePromocaoSelecionado) {
		this.filmePromocaoSelecionado = filmePromocaoSelecionado;
	}

	public void buscarFilme()
    {
    	if(pkFilme != 0)
    	{
    		filmePromocaoSelecionado = new FilmePromocaoDAO().findById(pkFilme);
    		filmePromocaoSelecionado.getFilme().setElenco(new ElencoDAO().obterElenco(filmePromocaoSelecionado.getFilme().getPkFilme()));
    		avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmePromocaoSelecionado.getFilme().getPkFilme());
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
		return filmePromocaoSelecionado!=null;
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
			if(filmePromocaoSelecionado==null)
			{
				filmePromocaoSelecionado = new FilmePromocaoDAO().findById(pkFilme);
			}
			
			AvaliacaoFilme ava = new AvaliacaoFilme();
			
			ava.setFilme(filmePromocaoSelecionado.getFilme());
			ava.setAvaliacao(avaliacao);
			ava.setEmail(email);
			ava.setNome(nome);
			ava.setComentario(comentario);
			
			ava = new AvaliacaoFilmeDAO().save(ava);
			new UtilDAO().obterMediaAvaliacoes(filmePromocaoSelecionado.getFilme());
			
			if(ava!=null)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensagem", "Avaliação Salva com Sucesso!"));  
				avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmePromocaoSelecionado.getFilme().getPkFilme());
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
