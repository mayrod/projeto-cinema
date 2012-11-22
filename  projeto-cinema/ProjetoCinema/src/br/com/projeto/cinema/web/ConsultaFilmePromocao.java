package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;

@ManagedBean(name="fpromocao")
public class ConsultaFilmePromocao {
	
    private List<FilmePromocao> filmesPromocao;
	private FilmePromocao filmePromocaoSelecionado;
	private Long pkFilme;
	
	public List<FilmePromocao> getFilmesPromocao() {
		filmesPromocao = new ArrayList<FilmePromocao>();
		
		try {
			filmesPromocao = new FilmePromocaoDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
    	}
    }

	public Long getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(Long pkFilme) {
		this.pkFilme = pkFilme;
	}
}
