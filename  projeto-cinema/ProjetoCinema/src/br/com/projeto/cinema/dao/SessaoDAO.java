package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.Sessao;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class SessaoDAO extends GenericDao<Sessao> 
{
	public List<Sessao> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM Sessao"), Sessao.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Sessao sessao){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Sessao.class, sessao.getPkSessao()));  
        em.getTransaction().commit();  
        em.close();  
	}
	
	public List<Sessao> getSessaoPorFilme(Filme filme, String horario, Long dia) throws Exception
	{
	        Query query = new Query();
		   
			query.add("SELECT *");
			query.add(" FROM Sessao");
			query.add(" WHERE pkFilmeHorario IS NOT NULL");
			if(filme != null) 	{ query.add(" AND fkFilme = ?", filme.getPkFilme()); 	}
			if(horario != null || dia!=null) 			
			{ 
				query.add(" AND fkHorario IN (select pkHorario from Horario");
				query.add(" WHERE pkHorario IS NOT NULL");
				if(horario!=null) { query.add(" AND horario = ?", horario); }
				if(dia!=null) 	  { query.add(" AND diaSemana = ?", dia); }
				query.add(")");
			}
			
			return obtemTodos(query, Sessao.class); 
	}
}
