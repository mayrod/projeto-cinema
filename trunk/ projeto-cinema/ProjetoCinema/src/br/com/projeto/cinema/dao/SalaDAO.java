package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.Sala;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class SalaDAO extends GenericDao<Sala> 
{
	public List<Sala> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM Sala"), Sala.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Sala sala){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Sala.class, sala.getPkSala()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
