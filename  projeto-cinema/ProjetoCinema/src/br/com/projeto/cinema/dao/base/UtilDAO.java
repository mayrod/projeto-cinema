package br.com.projeto.cinema.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.utils.Query;

public class UtilDAO {
	
	 @PersistenceContext(unitName = "cinema")	
	    private final EntityManager entityManager;
	
		public UtilDAO() {
	        this.entityManager = FactoryUtil.getEntityManager();
	    }
	
	    private EntityManager getEntityManager() {
	        return entityManager;
	    }
	
	
		public Double obterMediaAvaliacoes(Filme filme) throws Exception
		{
		    Session session = (Session) getEntityManager().getDelegate();
			Query query = new Query();
			
			query.add("SELECT AVG(avaliacao)");
			query.add(" FROM AvaliacaoFilme");
			query.add(" WHERE fkFilme = ?", filme.getPkFilme());
			
			Double num = (Double) session.createQuery(query.toString()).uniqueResult();
			
			if(num!=null) 
			{ 
				filme.setAvaliacaoGeral((int) Math.ceil(num));
				new FilmeDAO().update(filme);
			}
			
			return num;
		}

}
