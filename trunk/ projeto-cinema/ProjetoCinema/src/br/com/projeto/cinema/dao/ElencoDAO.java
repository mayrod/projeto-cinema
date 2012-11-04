package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.Elenco;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class ElencoDAO extends GenericDao<Elenco> 
{
	public List<Elenco> obterElenco(Long pkFilme)
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM Elenco");
			query.add(" WHERE fkFilme = ?", pkFilme);
			
			return obtemTodos(query, Elenco.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public boolean removerForaLista(Long pkFilme)
	{
		try
		{
			Query query = new Query();
			
			query.add("DELETE");
			query.add(" FROM Elenco");
			query.add(" WHERE fkFilme = ?", pkFilme);
			
			obtem(query, Elenco.class);
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
