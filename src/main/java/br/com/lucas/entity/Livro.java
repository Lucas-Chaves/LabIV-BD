package br.com.lucas.entity;

import javax.persistence.*;

@Entity
@Table(name="livro")
@PrimaryKeyJoinColumn(name = "id_produto")
public class Livro extends Produto{

    @Column(name="liv_author")
    private String author;

    @Column(name="liv_titulo")
    private String titulo;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
