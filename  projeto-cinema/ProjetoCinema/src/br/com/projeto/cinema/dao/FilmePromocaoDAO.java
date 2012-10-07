package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class FilmePromocaoDAO extends GenericDao<FilmePromocao> 
{
	public List<FilmePromocao> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM FilmePromocao"), FilmePromocao.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
