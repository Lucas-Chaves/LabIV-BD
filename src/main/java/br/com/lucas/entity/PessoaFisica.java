package br.com.lucas.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa {


    @Column(name = "cpf_pess")
    private String cpf;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}