package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class HorarioDAO extends GenericDao<Horario> 
{
	public List<Horario> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM Horario"), Horario.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Horario horario){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Horario.class, horario.getPkHorario()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
