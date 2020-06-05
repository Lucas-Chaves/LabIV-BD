package br.com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static PersistenceManager manager;

    private EntityManagerFactory factory;

    private PersistenceManager() {

    }

    public static PersistenceManager getInstance() {
        if(manager == null) {
            manager = new PersistenceManager();
        }
        return manager;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if(factory == null) {
            factory = Persistence
                    .createEntityManagerFactory("avaliacao");
        }
        return factory;
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

}
