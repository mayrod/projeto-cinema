package br.com.projeto.cinema.dao;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;

public class FilmeLancamentoDAO extends GenericDao<FilmeLancamento> 
{
	public void delete(FilmeLancamento filmeLan){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmeLancamento.class, filmeLan.getPkFilmeLancamento()));  
        em.getTransaction().commit();  
        em.close();  
	}
}
