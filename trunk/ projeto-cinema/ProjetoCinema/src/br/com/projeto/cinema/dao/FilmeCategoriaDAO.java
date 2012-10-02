package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class FilmeCategoriaDAO extends GenericDao<FilmeCategoria> 
{
	public List<FilmeCategoria> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM FilmeCategoria"), FilmeCategoria.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
