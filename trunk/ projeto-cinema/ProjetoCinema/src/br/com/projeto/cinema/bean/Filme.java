package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILME")
public class Filme implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "pkFilme")
	private Long pkFilme;
	
	@Column(name = "ano")
	private String ano;
	
	@Column(name = "classificacaoIndicativa")
	private String classificacaoIndicativa;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "diretor")
	private String diretor;
	
	@Column(name = "duracao")
	private String duracao;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@Column(name = "tipoAudio")
	private String tipoAudio;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "pathImagem")
	private String pathImagem;
	
	@Column(name = "trailer")
	private String trailer;
	
	@Column(name = "legenda")
	private String legenda;
	
	@Column(name = "produtora")
	private String produtora;
	
	@OneToOne @JoinColumn(name="fkCategoria")
	private FilmeCategoria categoria;
	
	@OneToMany @JoinTable(name="filmeHorario" , joinColumns = @JoinColumn(name = "pkFilme"), inverseJoinColumns = @JoinColumn(name = "pkFilmeHorario"))
	private List<FilmeHorario> horariosExibicoes;
	
	@OneToMany @JoinTable(name="avaliacaofilme" , joinColumns = @JoinColumn(name = "pkFilme"), inverseJoinColumns = @JoinColumn(name = "pkAvaliacaoFilme"))
	private List<AvaliacaoFilme> avaliacoes;

	public Long getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(Long pkFilme) {
		this.pkFilme = pkFilme;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getTipoAudio() {
		return tipoAudio;
	}

	public void setTipoAudio(String tipoAudio) {
		this.tipoAudio = tipoAudio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public FilmeCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(FilmeCategoria categoria) {
		this.categoria = categoria;
	}


	public List<FilmeHorario> getHorariosExibicoes() {
		return horariosExibicoes;
	}

	public void setHorariosExibicoes(List<FilmeHorario> horariosExibicoes) {
		this.horariosExibicoes = horariosExibicoes;
	}

	public List<AvaliacaoFilme> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFilme> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	
}
