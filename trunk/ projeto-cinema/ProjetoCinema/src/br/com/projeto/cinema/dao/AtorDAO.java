package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.dao.base.GenericDao;

public class AtorDAO extends GenericDao<Ator> 
{
	public Ator salvar(Ator ator)
	{
		return save(ator);
	}
	
	public Ator remover(Ator ator)
	{
		try {
			return obtem("DELETE FROM Ator WHERE pkAtor = " + ator.getPkAtor(),Ator.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Ator> obterTodos()
	{
		try 
		{
			return obtemTodos("SELECT * FROM Ator", Ator.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
