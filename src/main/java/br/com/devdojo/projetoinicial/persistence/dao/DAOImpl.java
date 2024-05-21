package br.com.devdojo.projetoinicial.persistence.dao;

import br.com.devdojo.projetoinicial.persistence.daointerfaces.DAO;
import br.com.devdojo.projetoinicial.persistence.fileservice.FileXMLService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DAOImpl<T> implements DAO<T> {

    @PersistenceContext
    private EntityManager em;
    private final Class<T> classe;
    private static final FileXMLService hqlQuery;
    private static final FileXMLService sqlQuery;

    static {
        hqlQuery = new FileXMLService("hql.xml");
        sqlQuery = new FileXMLService("sql.xml");
    }

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

    @Override
    public List<T> findHQLQueryNoParameters(String queryId, int maxResults) {
        String hql = hqlQuery.findValue(queryId);
        TypedQuery<T> query = em.createQuery(hql, this.classe);
        return maxResults == 0 ? query.getResultList() : query.setMaxResults(maxResults).getResultList();
    }

    @Override
    public List<T> findHQLQuery(String queryId, List<Object> values, int maxResults) {
        String hql = hqlQuery.findValue(queryId);
        Pattern pattern = Pattern.compile("(:\\w+)");
        Matcher matcher = pattern.matcher(hql);
        ArrayList<String> params = new ArrayList<>();
        while (matcher.find()) {
            params.add(matcher.group().replace(":", ""));
        }
        TypedQuery<T> query = em.createQuery(hql, this.classe);
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(params.get(i), values.get(i));
        }
        return maxResults == 0 ? query.getResultList() : query.setMaxResults(maxResults).getResultList();
    }

    @Override
    public void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.flush();
    }

    @Override
    public T findById(Serializable id) {
        return em.find(this.classe, id);
    }
}