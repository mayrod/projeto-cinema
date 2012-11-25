package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class AvaliacaoFilmeDAO extends GenericDao<AvaliacaoFilme> 
{
	public List<AvaliacaoFilme> obterAvaliacoes(Long pkFilme)
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM AvaliacaoFilme");
			query.add(" WHERE fkFilme = ?", pkFilme);
						
			return obtemTodos(query, AvaliacaoFilme.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
