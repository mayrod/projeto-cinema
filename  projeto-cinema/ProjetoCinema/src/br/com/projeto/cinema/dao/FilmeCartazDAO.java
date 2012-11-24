package br.com.projeto.cinema.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Constantes;
import br.com.projeto.cinema.utils.Query;

public class FilmeCartazDAO extends GenericDao<FilmeCartaz> 
{
	public void delete(FilmeCartaz filmec){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmeCartaz.class, filmec.getPkFilmeCartaz()));  
        em.getTransaction().commit();  
        em.close();  
	}
	
	public List<FilmeCartaz> obterTodos()
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM FilmeCartaz");
			query.add(" WHERE status = ?", Constantes.STATUS_ATIVO);
			
			return obtemTodos(query, FilmeCartaz.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void atualizarStatus() throws Exception
	{
		Query query = new Query();
		
		query.add("UPDATE FilmeCartaz");
		query.add(" SET status = ?", Constantes.STATUS_REMOVIDO);
		query.add(" WHERE dataInicio > ?", new Date());
		query.add(" OR dataTermino < ?", new Date());
		
		obtem(query, FilmeCartaz.class);
						
		query = new Query();
		
		query.add("UPDATE FilmeCartaz");
		query.add(" SET status = ?", Constantes.STATUS_ATIVO);
		query.add(" WHERE dataInicio <= ?", new Date());
		query.add(" AND dataTermino >= ?", new Date());
		
		obtem(query, FilmeCartaz.class);
		
		query = new Query();
		
		query.add("SELECT *");
		query.add(" FROM FilmeLancamento");
		query.add(" WHERE status = ?", Constantes.STATUS_REMOVIDO);
		query.add(" AND fkFilme NOT IN(", Constantes.STATUS_REMOVIDO);
		query.add(" SELECT fkFilme FROM FilmeCartaz)", Constantes.STATUS_REMOVIDO);
		
		List<FilmeLancamento> filmes = new FilmeLancamentoDAO().obtemTodos(query, FilmeLancamento.class);
		
		if(filmes!=null)
		{
			for(FilmeLancamento fl : filmes)
			{
				FilmeCartaz fc = new FilmeCartaz();
				Date dfinal = (Date) fl.getDataEstreia().clone();
				dfinal.setMonth(dfinal.getMonth() + 1);
				
				fc.setFilme(fl.getFilme());
				fc.setDataInicio(fl.getDataEstreia());
				fc.setDataTermino(dfinal);
				fc.setFilme(fl.getFilme());
				fc.setStatus(Constantes.STATUS_ATIVO);
				
				save(fc);
			}
		}
	}
}
