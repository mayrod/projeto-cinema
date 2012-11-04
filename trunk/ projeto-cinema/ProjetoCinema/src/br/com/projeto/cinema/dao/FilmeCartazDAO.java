package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.dao.base.FactoryUtil;
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

	public void delete(FilmeCartaz filmec){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmeCartaz.class, filmec.getPkFilmeCartaz()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
