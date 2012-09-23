package br.com.projeto.cinema.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryUtil {

	 private static EntityManagerFactory emf;

          public static EntityManager getEntityManager() {
 
              if (emf == null){
                  emf = Persistence.createEntityManagerFactory("cinema");
              }
              return emf.createEntityManager();
          }

}
