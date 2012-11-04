package br.com.projeto.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.projeto.cinema.bean.Elenco;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.base.FactoryUtil;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class FilmeDAO  extends GenericDao<Filme> 
{
	public void delete(Filme filme){
        EntityManager em  =  FactoryUtil.getEntityManager();  
        em.getTransaction().begin();   
        em.remove(em.getReference(Filme.class, filme.getPkFilme()));  
        em.getTransaction().commit();  
        em.close();  
	}
	
	public boolean salvarTodos(List<Elenco> listElenco)
	{
		try
		{
			for(Elenco el : listElenco)
			{
				el = new ElencoDAO().save(el);
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public List<Filme> obterFilmes(String codigo, String titulo, Long pkFilmeCategoria, String classificacao, String ano)
	{
		try
		{
			Query query = new Query();
			
			query.add("SELECT *");
			query.add(" FROM Filme");
			query.add(" WHERE pkFilme IS NOT NULL");
			if(!codigo.equals("")) 			{ query.add(" AND UPPER(codigo) LIKE UPPER(?)", "%" + codigo + "%"); 	}
			if(!titulo.equals("")) 			{ query.add(" AND UPPER(titulo) LIKE UPPER(?)", "%" + titulo + "%");	}
			if(pkFilmeCategoria!=null) 		{ query.add(" AND fkTitulo = ?", pkFilmeCategoria); 					}
			if(classificacao!=null)			{ query.add(" AND classificacaoIndicativa = ?", classificacao); 		}
			if(!ano.equals("")) 			{ query.add(" AND UPPER(ano) LIKE UPPER(?)", "%" + ano + "%"); 			}
			query.add(" ORDER BY titulo");
			
			return obtemTodos(query, Filme.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> getFilmes(FilmeCategoria categoria){
		   Session session = (Session) getEntityManager().getDelegate();
	        return  session.createCriteria(Filme.class).add(Restrictions.eq("categoria", categoria)).list();
	}
}
