package br.com.devdojo.projetoinicial.persistence.daointerfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thiago on 19/05/2024.
 */
public interface DAO<T> implements Serializable {

    public abstract T save(T entity);

    public abstract T update(T entity);

    public abstract List<T> listAll(T entity);
}
