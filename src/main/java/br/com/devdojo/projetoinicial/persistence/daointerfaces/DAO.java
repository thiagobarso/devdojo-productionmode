package br.com.devdojo.projetoinicial.persistence.daointerfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thiago on 19/05/2024.
 */
public interface DAO<T> extends Serializable {

    T save(T entity);

    T update(T entity);

    List<T> listAll();

    List<T> findHQLQuery(String queryId, List<Object> values, int maxResults);

    List<T> findHQLQueryNoParameters(String queryId, int maxResults);
}
