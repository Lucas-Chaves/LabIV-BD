package br.com.lucas.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="produto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AttributeOverride(name = "id", column = @Column(name = "id_produto"))
public class Produto extends BaseEntity{

    @Column(name="produto_name")
    private String nameProduto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca")
    private Marca marca;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "estoque_produto",
            joinColumns = { @JoinColumn(name = "id_produto") },
            inverseJoinColumns = { @JoinColumn(name = "id_est") })
    private Set<Estoque>  estoques;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "estoque")
    public Set<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(Set<Estoque> estoques) {
        this.estoques = estoques;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNameProduto() {
        return nameProduto;
    }

    public void setNameProduto(String nameProduto) {
        this.nameProduto = nameProduto;
    }
}
