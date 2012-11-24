package br.com.projeto.cinema.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Constantes;
import br.com.projeto.cinema.utils.Query;

public class FilmePromocaoDAO extends GenericDao<FilmePromocao> 
{
	public List<FilmePromocao> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM FilmePromocao WHERE status = ?", Constantes.STATUS_ATIVO), FilmePromocao.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(FilmePromocao filmePro){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(FilmePromocao.class, filmePro.getPkFilmePromocao()));  
        em.getTransaction().commit();  
        em.close();  
	}
	
	public void atualizarStatus() throws Exception
	{
		Query query = new Query();
		
		query.add("UPDATE FilmePromocao");
		query.add(" SET status = ?", Constantes.STATUS_REMOVIDO);
		query.add(" WHERE dataInicio > ?", new Date());
		query.add(" OR dataTermino < ?", new Date());
		
		obtem(query, FilmePromocao.class);
		
		query = new Query();
		
		query.add("UPDATE FilmePromocao");
		query.add(" SET status = ?", Constantes.STATUS_ATIVO);
		query.add(" WHERE dataInicio <= ?", new Date());
		query.add(" AND dataTermino >= ?", new Date());
		
		obtem(query, FilmePromocao.class);
	}
}
