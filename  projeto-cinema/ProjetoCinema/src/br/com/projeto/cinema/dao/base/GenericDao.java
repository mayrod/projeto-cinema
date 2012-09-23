package br.com.projeto.cinema.dao.base;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.DataException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class GenericDao<T extends Serializable> {

	  @PersistenceContext(unitName = "pet")	
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

	    public void save(T entity) {
	        EntityTransaction tx = getEntityManager().getTransaction();

	        try {
	            tx.begin();
	            getEntityManager().persist(entity);
	            tx.commit();
	
	        } catch (Throwable t) {
	            t.printStackTrace();
	            tx.rollback();
	        } finally {
	            close();
	        }
	    }
	

	    public void update(T entity) {
	        EntityTransaction tx = getEntityManager().getTransaction();
	        try {
	            tx.begin();
	            getEntityManager().merge(entity);
	            tx.commit();
	
	        } catch (Throwable t) {
	            t.printStackTrace();
	            tx.rollback();
	        } finally {
	            close();
	        }
	    }

	    public void delete(T entity) {
	        EntityTransaction tx = getEntityManager().getTransaction();

	        try {
	            tx.begin();
	            getEntityManager().remove(entity);
	            tx.commit();
	
	        } catch (Throwable t) {
	            t.printStackTrace();
	            tx.rollback();
	
	        } finally {
	            close();
	        }
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
	    
	   public int count() throws DataException { 
		    Session session = (Session) this.getEntityManager().getDelegate();
		    Criteria criteria = session.createCriteria(persistentClass);
		    criteria.setProjection(Projections.rowCount());
	
		    Integer count = (Integer) criteria.uniqueResult();
		    return count;
	  }
}



