package br.com.projeto.cinema.dao.base;



import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.DataException;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.Elenco;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.bean.FilmeHorarioExibicao;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.bean.HorarioExibicao;
import br.com.projeto.cinema.bean.Pessoa;
import br.com.projeto.cinema.bean.Preco;
import br.com.projeto.cinema.bean.Produtora;
import br.com.projeto.cinema.bean.Sala;
import br.com.projeto.cinema.bean.Usuario;

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
	   
		public T obtem(String query, Class<T> classe) throws Exception
		{
			Session session = (Session) getEntityManager().getDelegate();
			
			SQLQuery select = session.createSQLQuery(query).addEntity(classe);  
			
			if(select.list()!=null && select.list().size()>0 && select.list().get(0)!=null)
			{
				return (T) select.list().get(0);
			}
			return null;
		}
		
		public List<T> obtemTodos(String query, Class<T> classe) throws Exception
		{
			Session session = (Session) getEntityManager().getDelegate();
			
			SQLQuery select = session.createSQLQuery(query).addEntity(classe);  
			
			if(select.list()!=null && select.list().size()>0)
			{
				return select.list();
			}
			return null;
		}
}



