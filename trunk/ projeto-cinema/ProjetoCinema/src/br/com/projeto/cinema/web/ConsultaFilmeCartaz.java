package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.dao.FilmeCartazDAO;

@ManagedBean(name="fcartaz")
public class ConsultaFilmeCartaz {
	
    private List<FilmeCartaz> filmesCartaz;
	private FilmeCartaz filmeCartazSelecionado;
	private Long pkFilme;
	
	public List<FilmeCartaz> getFilmesCartaz() {
		filmesCartaz = new ArrayList<FilmeCartaz>();
		
		try {
			filmesCartaz = new FilmeCartazDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
    	}
    }

	public Long getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(Long pkFilme) {
		this.pkFilme = pkFilme;
	}
}
