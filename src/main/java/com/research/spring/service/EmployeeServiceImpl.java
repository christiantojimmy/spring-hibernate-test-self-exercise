package com.research.spring.service;

import com.research.spring.dao.EmployeeDao;
import com.research.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:04 PM
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    public Employee selectById(Integer id) {
        return employeeDao.selectById(id);
    }

    public void insert(Employee item) {
        employeeDao.insert(item);
    }

    public void update(Employee item) {
        Employee employee = employeeDao.selectById(item.getId());
        if (employee != null) {
            employee.setName(item.getName());
        }
    }

    public void delete(Integer id) {
        employeeDao.delete(id);
    }
}
