package br.com.projeto.cinema.dao;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class FilmeLancamentoDAO extends GenericDao<FilmeLancamento> 
{
	public void delete(FilmeLancamento filmeLan){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmeLancamento.class, filmeLan.getPkFilmeLancamento()));  
        em.getTransaction().commit();  
        em.close();  
	}
	
	public FilmeLancamento obterFilmeLancamento(Long pk)
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM FilmeLancamento");
			query.add(" WHERE pkFilmeLancamento = ?", pk);
			
			
			return obtem(query, FilmeLancamento.class);
		}
		catch (Exception e) {
			return null;
		}
	}
}
