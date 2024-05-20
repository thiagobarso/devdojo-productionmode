package br.com.devdojo.projetoinicial.bean;

import br.com.devdojo.projetoinicial.annotations.Transactional;
import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;
import br.com.devdojo.projetoinicial.persistence.model.Projeto;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class TesteBean implements Serializable {

    @Inject
    private DAO<Projeto> dao;

    @Transactional
    public void init() throws Exception {
//        Projeto p1 = new Projeto();
//        p1.setNome("Projeto Teste");
//
//        Projeto p2 = new Projeto();
//        p2.setNome("Projeto Teste 2");
//
//        dao.save(p1);
//        if(true)
//            throw new Exception();
//        dao.save(p2);
//
//        System.out.println("hadouken");

//        List<Projeto> projetos = dao.listAll();
//        System.out.println(projetos);


        List<Projeto> projetos = dao.findHQLQuery("searchProjectByName", Collections.singletonList("teste"), 0);
        System.out.println(projetos);

        List<Projeto> projetos2 = dao.findHQLQuery("searchProjectByName", Arrays.asList("teste", 4L), 0);
        System.out.println(projetos2);
    }
}