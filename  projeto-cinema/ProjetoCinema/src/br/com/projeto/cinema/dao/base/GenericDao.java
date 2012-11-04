package br.com.projeto.cinema.dao.base;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.DataException;

import br.com.projeto.cinema.utils.Query;


public class GenericDao<T extends Serializable> {

	  @PersistenceContext(unitName = "cinema")	
	    private final EntityManager entityManager;
	
	    private final Class<T> persistentClass;
	

	    @SuppressWarnings("unchecked")
		public GenericDao() {
	        this.entityManager = FactoryUtil.getEntityManager();
	        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	    }
	
	    public EntityManager getEntityManager() {
	        return entityManager;
	    }

	    public T save(T entity) {
	        EntityTransaction tx = getEntityManager().getTransaction();

	        try {
	            tx.begin();
	            getEntityManager().persist(entity);
	            tx.commit();
	            return entity;
	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	            tx.rollback();
	        } finally {
	            close();
	        }
	        
	        return null;
	    }
	

	    public T update(T entity) {
	        EntityTransaction tx = getEntityManager().getTransaction();
	        try {
	            tx.begin();
	            getEntityManager().merge(entity);
	            tx.commit();
	            return entity;
	        } catch (Throwable t) {
	            t.printStackTrace();
	            tx.rollback();
	        } finally {
	            close();
	        }
	        return null;
	    }
	
	    @SuppressWarnings("unchecked")
		public List<T> getAll() throws Exception {
	        Session session = (Session) getEntityManager().getDelegate();
	        return session.createCriteria(persistentClass).list();
	    }

	    @SuppressWarnings("unchecked")
		public T findByName(String nome) {
	        Session session = (Session) getEntityManager().getDelegate();
	        return (T) session.createCriteria(persistentClass).add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
	    }

	    @SuppressWarnings("unchecked")
		public T findById(long id) {
	        Session session = (Session) getEntityManager().getDelegate();
	        return (T) session.createCriteria(persistentClass).add(Restrictions.eq("id", id)).uniqueResult();
	    }
	
	    private void close() {	
	        if (getEntityManager().isOpen()) {
	            getEntityManager().close();
	        }
	    }
	    
	   public long count() throws DataException { 
		    Session session = (Session) this.getEntityManager().getDelegate();
		    Criteria criteria = session.createCriteria(persistentClass);
		    criteria.setProjection(Projections.rowCount());
	
		    Long count = (Long) criteria.uniqueResult();
		    return count;
	 	}
	   
		public T obtem(Query query, Class<T> classe) throws Exception
		{
			try 
			{	
				Session session = (Session) getEntityManager().getDelegate();
				
				SQLQuery select = session.createSQLQuery(query.toString()).addEntity(classe);  
				
				if(select.list()!=null && select.list().size()>0 && select.list().get(0)!=null)
				{
					return (T) select.list().get(0);
				}
			}
			catch (Exception e) {
			}
			return null;
		}
		
		public List<T> obtemTodos(Query query, Class<T> classe) throws Exception
		{
			try 
			{
				Session session = (Session) getEntityManager().getDelegate();
				
				SQLQuery select = session.createSQLQuery(query.toString()).addEntity(classe);  
				
				if(select.list()!=null && select.list().size()>0)
				{
					return select.list();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
	
}



