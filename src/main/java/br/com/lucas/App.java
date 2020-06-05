package br.com.lucas;

import br.com.lucas.dao.PersistenceManager;
import br.com.lucas.entity.Estoque;
import br.com.lucas.entity.Marca;

import javax.persistence.EntityManager;


public class App {
    public static void main( String[] args ){

        EntityManager manager = PersistenceManager
                .getInstance().getEntityManager();

        Estoque estoque = new Estoque();
        estoque.setName("Site");
        Marca marca = new Marca();
        marca.setName("Adidas");

        manager.getTransaction().begin();
        manager.persist(estoque);
        manager.persist(marca);
        manager.getTransaction().commit();


    }
}
