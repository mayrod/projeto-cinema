package br.com.projeto.cinema.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

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
	
	
		public Double obterMediaAvaliacoes(Long pkFilme)
		{
		    Session session = (Session) getEntityManager().getDelegate();
			Query query = new Query();
			
			query.add("SELECT AVG(avaliacao)");
			query.add(" FROM AvaliacaoFilme");
			query.add(" WHERE fkFilme = ?", pkFilme);
			
			return (Double) session.createQuery(query.toString()).uniqueResult();
		}

}
