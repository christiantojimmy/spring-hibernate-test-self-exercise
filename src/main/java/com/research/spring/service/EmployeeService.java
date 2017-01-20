package com.research.spring.service;

import com.research.spring.model.Employee;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:03 PM
 */
public interface EmployeeService {
    public List<Employee> selectAll();

    public Employee selectById(Integer id);

    public void insert(Employee item);

    public void update(Employee item);

    public void delete(Integer id);
}
