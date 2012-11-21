package br.com.projeto.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.bean.Sessao;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.dao.HorarioDAO;
import br.com.projeto.cinema.dao.SessaoDAO;

@ManagedBean(name="horario")
public class ConsultaHorario {
	
	private String horario;
	private int pkFilme;
	private String pkHorario;
	private Filme filme;
	private List<Sessao> sessoes;
	private int diaSemana;
	
    public List<Filme> getFilmes(){
			
			List<Filme> filmes = new ArrayList<Filme>();
			
			try {
			    filmes = new FilmeDAO().getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filmes;
	}
    
    public List<String> getHorarios() throws Exception{
		return new HorarioDAO().getHorarios();
    }

    
    public void buscarSessao()
    {
	    filme = new FilmeDAO().findById(new Long(pkFilme));
    	String horario = null;
    	Long dia = null;
    	
    	if(!pkHorario.equals("0")) { horario = pkHorario; }
    	if(diaSemana!=0) { dia = new Long(diaSemana); }

    	try {
			sessoes = new SessaoDAO().getSessaoPorFilme(filme,horario, dia);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

	public int getPkFilme() {
		return pkFilme;
	}

	public void setPkFilme(int pkFilme) {
		this.pkFilme = pkFilme;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPkHorario() {
		return pkHorario;
	}

	public void setPkHorario(String pkHorario) {
		this.pkHorario = pkHorario;
	}

}
