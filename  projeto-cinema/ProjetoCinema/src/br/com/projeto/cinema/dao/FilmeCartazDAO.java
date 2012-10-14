package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class FilmeCartazDAO extends GenericDao<FilmeCartaz> {
	
	public List<FilmeCartaz> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM FilmeCartaz"), FilmeCartaz.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
