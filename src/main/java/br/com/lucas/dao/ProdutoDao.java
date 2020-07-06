package br.com.lucas.dao;

import br.com.lucas.entity.Estoque;
import br.com.lucas.entity.Livro;
import br.com.lucas.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDao {

    EntityManager manager = PersistenceManager
            .getInstance().getEntityManager();

    public Produto buscar(int id){
        return manager.find(Produto.class, id);
    }

    public void salvar(Produto produto) throws RollbackException {
        try{
            manager.getTransaction().begin();
            manager.merge(produto);
            manager.getTransaction().commit();
        }catch (RollbackException e){
            manager.getTransaction().rollback();
            throw e;
        }
    }

    public void innerProduto(String marcaName, String produtoName){

        String queryText = "select p from Produto p "
                + "inner join p.marca m "
                + "where m.name like :name "
                + "and p.nameProduto like :produtoName";

        TypedQuery<Produto> query1 = manager.createQuery(queryText, Produto.class);
        query1.setParameter("name", marcaName);
        query1.setParameter("produtoName", produtoName);

        List<Produto> resultados = query1.getResultList();

        int index = 1;
        for(Produto prod: resultados) {

            System.out.println("Index: " + index);
            System.out.println("Título: " + prod.getNameProduto());
            System.out.println("Marca: " + prod.getMarca().getName());
            for(Estoque est: prod.getEstoques()){
                System.out.println("Estoque: " + est.getName());
            }

            System.out.println("--------------------------------------------------------------------");
            index++;
        }
    }


    public void innerProdutoEstoque(String estoqueTipo, String produtoName){

        String queryText = "select p from Produto p "
                + "inner join p.estoques e "
                + "where e.name like :name "
                + "and p.nameProduto like :produtoName";

        TypedQuery<Produto> query1 = manager.createQuery(queryText, Produto.class);
        query1.setParameter("name", estoqueTipo);
        query1.setParameter("produtoName", produtoName);

        List<Produto> resultados = query1.getResultList();

        int index = 1;
        for(Produto prod: resultados) {

            System.out.println("Index: " + index);
            System.out.println("Título: " + prod.getNameProduto());
            System.out.println("Marca: " + prod.getMarca().getName());
            for(Estoque est: prod.getEstoques()){
                System.out.println("Estoque: " + est.getName());
            }

            System.out.println("--------------------------------------------------------------------");
            index++;
        }
    }

}
