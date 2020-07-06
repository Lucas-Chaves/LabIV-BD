package br.com.lucas.dao;

import br.com.lucas.entity.Estoque;
import br.com.lucas.entity.Livro;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivroDAO {

    EntityManager manager = PersistenceManager
            .getInstance().getEntityManager();


    public Livro buscar(int id){
        return manager.find(Livro.class, id);
    }

    public void salvar(Livro livro) throws RollbackException{
        try{
            manager.getTransaction().begin();
            manager.merge(livro);
            manager.getTransaction().commit();
        }catch (RollbackException e){
            manager.getTransaction().rollback();
            throw e;
        }
    }


    public void innerLivro(){
        String queryText1 = "select l from Livro l " +
                "where l.author = :name";

        TypedQuery<Livro> query2 = manager.createQuery(queryText1, Livro.class);
        query2.setParameter("name", "Lucas");
        List<Livro> resultadoLivros = query2.getResultList();


        int index = 1;
        for(Livro liv: resultadoLivros) {

            System.out.println("Index: " + index);
            System.out.println("tipo do produto: " + liv.getNameProduto());
            System.out.println("Marca: " + liv.getMarca().getName());
            System.out.println("Titulo: " + liv.getTitulo());
            System.out.println("Author: " + liv.getAuthor());

            for(Estoque est: liv.getEstoques()){
                System.out.println("Estoque: " + est.getName());
            }

            System.out.println("--------------------------------------------------------------------");
            index++;
        }
    }
}
