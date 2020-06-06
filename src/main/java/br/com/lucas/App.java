package br.com.lucas;

import br.com.lucas.dao.PersistenceManager;
import br.com.lucas.entity.Estoque;
import br.com.lucas.entity.Marca;
import br.com.lucas.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;


public class App {
    public static void main( String[] args ){

        EntityManager manager = PersistenceManager
                .getInstance().getEntityManager();

        Estoque estoque = new Estoque();
        estoque.setName("Site");
        Estoque estoque1 = new Estoque();
        estoque1.setName("Loja");
        Marca marca = new Marca();
        marca.setName("Adidas");
        Produto produto = new Produto();
        produto.setNameProduto("Shampoo");
        produto.setMarca(marca);
        produto.setEstoques(new HashSet<Estoque>());
        produto.getEstoques().add(estoque);
        produto.getEstoques().add(estoque1);

        manager.getTransaction().begin();
        manager.persist(estoque);
        manager.persist(estoque1);
        manager.persist(marca);
        manager.persist(produto);
        manager.getTransaction().commit();

        manager.clear();

        String queryText = "select p " +
                "from Produto p " +
                "where p.nameProduto = :name";

        TypedQuery<Produto> query1 = manager.createQuery(queryText, Produto.class);
        query1.setParameter("name", "shampoo");

        List<Produto> resultados = query1.getResultList();

        for(Produto prod: resultados) {
            System.out.println("Título: " + prod.getNameProduto());
        }


    }
}
