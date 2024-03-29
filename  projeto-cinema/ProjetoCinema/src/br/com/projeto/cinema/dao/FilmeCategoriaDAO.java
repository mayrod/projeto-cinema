package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.base.FactoryUtil;
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
	
	public void delete(FilmeCategoria filmeCategoria){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmeCategoria.class, filmeCategoria.getPkFilmeCategoria()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
