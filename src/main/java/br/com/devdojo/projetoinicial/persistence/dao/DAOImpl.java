package br.com.devdojo.projetoinicial.persistence.dao;

import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DAOImpl<T> implements DAO<T> {

    @PersistenceContext
    private EntityManager em;
    private final Class<T> classe;

    public DAOImpl(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;
    }

    @Override
    public T save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        return entity;

    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public List<T> listAll(T entity) {
        return null;
    }
}