package br.com.projeto.cinema.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Constantes;
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
			query.add(" WHERE status = ?", Constantes.STATUS_ATIVO);
			query.add(" AND pkFilmeLancamento = ?", pk);
			
			return obtem(query, FilmeLancamento.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public List<FilmeLancamento> obterFilmeLancamento(int status)
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM FilmeLancamento");
			query.add(" WHERE status = ?", status);
			
			return obtemTodos(query, FilmeLancamento.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void atualizarStatus() throws Exception
	{
		Query query = new Query();
		
		query.add("UPDATE FilmeLancamento");
		query.add(" SET status = ?", Constantes.STATUS_REMOVIDO);
		query.add(" WHERE dataEstreia <= ?", new Date());
		
		obtemTodos(query, FilmeLancamento.class);
		
		new FilmeCartazDAO().atualizarStatus();
		
		query = new Query();
		
		query.add("UPDATE FilmeLancamento");
		query.add(" SET status = ?", Constantes.STATUS_ATIVO);
		query.add(" WHERE dataEstreia > ?", new Date());
		
		obtem(query, FilmeLancamento.class);
	}
}
