package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class AtorDAO extends GenericDao<Ator> 
{
	public Ator salvar(Ator ator)
	{
		return save(ator);
	}
	
	public Ator remover(Ator ator)
	{
		try {
			return obtem(new Query("DELETE FROM Ator WHERE pkAtor = ?", ator.getPkAtor()),Ator.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Ator> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM Ator"), Ator.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Ator ator){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Ator.class, ator.getPkAtor()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
