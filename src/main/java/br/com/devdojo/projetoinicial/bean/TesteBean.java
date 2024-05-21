package br.com.devdojo.projetoinicial.bean;

import br.com.devdojo.projetoinicial.annotations.Transactional;
import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;
import br.com.devdojo.projetoinicial.persistence.model.Projeto;
import br.com.devdojo.projetoinicial.utils.FacesUtils;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.com.devdojo.projetoinicial.utils.StringUtils.like;

@Named
@ViewScoped
public class TesteBean implements Serializable {

    @Inject
    private DAO<Projeto> dao;
    private Projeto projeto;
    private List<Projeto> projetos;

    @PostConstruct
    public void init() {
        projetos = dao.listAll();
    }

    @Transactional
    public void construct() throws Exception {
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
//      List<Projeto> projetos2 = dao.findHQLQuery("searchProjectByName", Arrays.asList(like("teste"), 4L), 0);

//        List<Projeto> projetos = dao.findHQLQuery("searchProjectByName", Collections.singletonList("teste"), 0);
//        FacesUtils.addSuccessMessage("sucesso");

        try {
            Projeto projeto = new Projeto();
            Projeto projeto2 = new Projeto();
            projeto.setNome("Projeto 1");
            projeto2.setNome("Projeto 2");
            dao.save(projeto);
            if (true)
                throw new Exception("testando transação");
            dao.save(projeto2);
            FacesUtils.addSuccessMessage("sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("erro");
            throw e;
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}