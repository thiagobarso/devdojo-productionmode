package br.com.devdojo.projetoinicial.persistence.model;

import javax.persistence.Entity;

@Entity
public class Projeto extends AbstractEntity {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}