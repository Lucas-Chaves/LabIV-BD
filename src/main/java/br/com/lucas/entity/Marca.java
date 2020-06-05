package br.com.lucas.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="marca")
@AttributeOverride(name = "id", column = @Column(name = "id_marca"))
public class Marca extends BaseEntity {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="marca_name")
    private String name;


}
