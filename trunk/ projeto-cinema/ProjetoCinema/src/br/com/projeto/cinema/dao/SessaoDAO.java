package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
}
