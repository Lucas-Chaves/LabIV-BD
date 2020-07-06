package br.com.lucas;

import br.com.lucas.dao.LivroDAO;
import br.com.lucas.dao.PersistenceManager;
import br.com.lucas.dao.ProdutoDao;
import br.com.lucas.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;


public class App {
    public static void main( String[] args ){

        EntityManager manager = PersistenceManager
                .getInstance().getEntityManager();

        LivroDAO livroDAO = new LivroDAO();

        //Busca Livro pelo ID
        System.out.println(livroDAO.buscar(2).getTitulo());
        System.out.println("-------------------------------------------------------------------- começa o select livros");
        //busca livro
        livroDAO.innerLivro();

        ProdutoDao produtoDao = new ProdutoDao();

        // Criando marca
        Marca marca = new Marca();
        marca.setName("Torra Torra");

        //Criando estoque
        Estoque estoque = new Estoque();
        estoque.setName("Site");
//        Estoque estoque1 = new Estoque();
//        estoque1.setName("Loja");

        // salvando as Classes sem DAO
        manager.getTransaction().begin();
        manager.persist(estoque);
//        manager.persist(estoque1);
        manager.persist(marca);
        manager.getTransaction().commit();


        //Criando produto
        Produto produto = new Produto();
        produto.setNameProduto("teste4");
        produto.setMarca(marca);
        produto.setEstoques(new HashSet<Estoque>());
        produto.getEstoques().add(estoque);
//        produto.getEstoques().add(estoque1);

        //Salvando produto DAO
        produtoDao.salvar(produto);

        //Buscando Produto
        Produto busca = produtoDao.buscar(2);
        System.out.println(busca.getNameProduto());


        produtoDao.innerProduto("Torra Torra", "teste2");


        produtoDao.innerProdutoEstoque("Loja", "teste2");



//        Estoque estoque = new Estoque();
//        estoque.setName("Site");
//        Estoque estoque1 = new Estoque();
//        estoque1.setName("Loja");
//
//        Marca marca = new Marca();
//        marca.setName("Adidas");
//
//
//        Marca marca1 = new Marca();
//        marca1.setName("Vagalume");
//
//        Produto produto = new Produto();
//        produto.setNameProduto("teste");
//        produto.setMarca(marca);
//        produto.setEstoques(new HashSet<Estoque>());
//        produto.getEstoques().add(estoque);
//        produto.getEstoques().add(estoque1);
//
//        Livro livro = new Livro();
//        livro.setAuthor("Lucas");
//        livro.setTitulo("Teste e mais testes");
//        livro.setNameProduto("Livros");
//        livro.setMarca(marca1);
//        livroDAO.salvar(livro);

//        produto.setEstoques(new HashSet<Estoque>());
//        produto.getEstoques().add(estoque);
//        produto.getEstoques().add(estoque1);
//
//
//
//        manager.getTransaction().begin();
//        manager.persist(estoque);
//        manager.persist(estoque1);
//        manager.persist(marca);
//        manager.persist(marca1);
//        manager.persist(produto);
//        manager.persist(livro);
//        manager.getTransaction().commit();
//
//        manager.clear();
//
//        PessoaFisica pessoaFisica = new PessoaFisica();
//        pessoaFisica.setNome("Lucas Chaves");
//        pessoaFisica.setCpf("39776308813");
//
//        PessoaJuridica pessoaJuridica = new PessoaJuridica();
//        pessoaJuridica.setNome("Lucas Chaves");
//        pessoaJuridica.setCnpj("459131990555");
//
//
//        manager.getTransaction().begin();
//        manager.persist(pessoaFisica);
//        manager.persist(pessoaJuridica);
//        manager.getTransaction().commit();
//
//
//        String queryText = "select p " +
//                "from Produto p " +
//                "where p.nameProduto = :name";
//
//        TypedQuery<Produto> query1 = manager.createQuery(queryText, Produto.class);
//        query1.setParameter("name", "Livros");
//
//        List<Produto> resultados = query1.getResultList();
//
//        int index = 1;
//        for(Produto prod: resultados) {
//
//            System.out.println("Index: " + index);
//            System.out.println("Título: " + prod.getNameProduto());
//            System.out.println("Marca: " + prod.getMarca().getName());
//            for(Estoque est: prod.getEstoques()){
//                System.out.println("Estoque: " + est.getName());
//            }
//
//            System.out.println("--------------------------------------------------------------------");
//            index++;
//        }
//
//
//
//        manager.clear();
//
//        String queryText1 = "select l " +
//                "from Livro l " +
//                "where l.author = :name";
//
//        TypedQuery<Livro> query2 = manager.createQuery(queryText1, Livro.class);
//        query2.setParameter("name", "Lucas");
//
//        List<Livro> resultadoLivros = query2.getResultList();
//
//        index = 1;
//        for(Livro liv: resultadoLivros) {
//
//            System.out.println("Index: " + index);
//            System.out.println("tipo do produto: " + liv.getNameProduto());
//            System.out.println("Marca: " + liv.getMarca().getName());
//            System.out.println("Titulo: " + liv.getTitulo());
//            System.out.println("Author: " + liv.getAuthor());
//
//            for(Estoque est: liv.getEstoques()){
//                System.out.println("Estoque: " + est.getName());
//            }
//
//            System.out.println("--------------------------------------------------------------------");
//            index++;
//        }
//
//        manager.clear();

    }
}
