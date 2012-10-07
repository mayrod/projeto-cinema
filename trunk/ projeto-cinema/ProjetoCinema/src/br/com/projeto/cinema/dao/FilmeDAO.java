package br.com.projeto.cinema.dao;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;

public class FilmeDAO  extends GenericDao<Filme> 
{
	public void delete(Filme filme){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Filme.class, filme.getPkFilme()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
