package com.research.spring.service;

import com.research.spring.model.Company;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:47 PM
 */
public interface CompanyService {
    public List<Company> selectAll();

    public Company selectById(Integer id);

    public void insert(Company item);

    public void update(Company item);

    public void delete(Integer id);
}
