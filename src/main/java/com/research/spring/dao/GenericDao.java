package com.research.spring.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 12:53 PM
 */
public interface GenericDao<PK extends Serializable, T> {

    public List<T> selectAll();
    public T selectById(PK id);
    public void insert(T item);
    public void delete(PK id);
    public long count();
}
