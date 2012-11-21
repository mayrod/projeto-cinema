package br.com.projeto.cinema.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.bean.Sessao;
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
	

	public List<String> getHorarios() throws Exception
	{
        Query query = new Query();
	   
		query.add("SELECT distinct on (horario) *");
		query.add(" FROM Horario");
		query.add(" order by horario");
		
		List<Horario> horarios = obtemTodos(query, Horario.class); 
		List<String>  todosHorarios = new ArrayList<String>();
	  
		
		if(horarios != null){
		   for(Horario h: horarios){
			   todosHorarios.add(h.getHorario());
		   }
		}
	   
	   return todosHorarios;
	  
	}
	
	
}
