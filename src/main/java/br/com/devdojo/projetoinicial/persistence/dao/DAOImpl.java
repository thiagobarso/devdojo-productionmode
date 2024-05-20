package br.com.devdojo.projetoinicial.persistence.dao;

import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        em.persist(entity);
        em.flush();
        return entity;

    }

    @Override
    public T update(T entity) {
        em.merge(entity);
        em.flush();
        return entity;

    }

    @Override
    public List<T> listAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e FROM ").append(this.classe.getSimpleName()).append(" e");
        TypedQuery<T> query = em.createQuery(sql.toString(), this.classe);
        return query.getResultList();
    }
}