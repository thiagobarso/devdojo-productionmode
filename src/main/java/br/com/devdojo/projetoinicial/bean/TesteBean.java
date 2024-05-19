package br.com.devdojo.projetoinicial.bean;

import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;
import br.com.devdojo.projetoinicial.persistence.model.Projeto;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class TesteBean implements Serializable {

    @Inject
    private DAO<Projeto> dao;

    public void init(){
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste");
        dao.save(projeto);

        System.out.println("hadouken");
    }
}