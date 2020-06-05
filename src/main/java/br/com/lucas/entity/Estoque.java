package br.com.lucas.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
@AttributeOverride(name = "id", column = @Column(name = "id_est"))
public class Estoque extends BaseEntity {

    @Column(name="estoque_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
