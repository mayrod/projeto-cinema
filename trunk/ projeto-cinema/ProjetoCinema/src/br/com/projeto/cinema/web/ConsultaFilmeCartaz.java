package br.com.projeto.cinema.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.dao.AvaliacaoFilmeDAO;
import br.com.projeto.cinema.dao.ElencoDAO;
import br.com.projeto.cinema.dao.FilmeCartazDAO;

@ManagedBean(name="fcartaz")
public class ConsultaFilmeCartaz {
	
    private List<FilmeCartaz> filmesCartaz;
	private FilmeCartaz filmeCartazSelecionado;
	private Long pkFilme;
	private Boolean visibilidade;
	private Integer avaliacao;
	private String comentario;
	private String email;
	private String nome;
	private List<AvaliacaoFilme> avaliacoes;
	
	public List<FilmeCartaz> getFilmesCartaz() throws Exception {
		new FilmeCartazDAO().atualizarStatus();
		filmesCartaz = new FilmeCartazDAO().obterTodos();
		
		return filmesCartaz;
	}

	public void setFilmesCartaz(List<FilmeCartaz> filmesCartaz) {
		this.filmesCartaz = filmesCartaz;
	}

	public FilmeCartaz getFilmeCartazSelecionado() {
		return filmeCartazSelecionado;
	}

	public void setFilmeCartazSelecionado(FilmeCartaz filmeCartazSelecionado) {
		this.filmeCartazSelecionado = filmeCartazSelecionado;
	}

	public void buscarFilme()
    {
    	if(pkFilme != 0)
    	{
    		filmeCartazSelecionado = new FilmeCartazDAO().findById(pkFilme);
    		filmeCartazSelecionado.getFilme().setElenco(new ElencoDAO().obterElenco(filmeCartazSelecionado.getFilme().getPkFilme()));
    		avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmeCartazSelecionado.getFilme().getPkFilme());
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
		return filmeCartazSelecionado!=null;
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

	public void salvarAvaliacao()
    {
		if(email!=null && !email.equals("") && nome!=null && !nome.equals(""))
		{
			if(filmeCartazSelecionado==null)
			{
				filmeCartazSelecionado = new FilmeCartazDAO().findById(pkFilme);
			}
			
			AvaliacaoFilme ava = new AvaliacaoFilme();
			
			ava.setFilme(filmeCartazSelecionado.getFilme());
			ava.setAvaliacao(avaliacao);
			ava.setEmail(email);
			ava.setNome(nome);
			ava.setComentario(comentario);
			
			ava = new AvaliacaoFilmeDAO().save(ava);
			
			if(ava!=null)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensagem", "Avaliação Salva com Sucesso!"));  
				avaliacoes = new AvaliacaoFilmeDAO().obterAvaliacoes(filmeCartazSelecionado.getFilme().getPkFilme());
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
