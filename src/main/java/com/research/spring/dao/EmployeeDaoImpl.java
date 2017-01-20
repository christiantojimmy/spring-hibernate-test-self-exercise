package com.research.spring.dao;

import com.research.spring.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 12:55 PM
 */
@Repository
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

    public List<Employee> selectAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }

    public Employee selectById(Integer id) {
        return getByKey(id);
    }

    public void insert(Employee item) {
        persist(item);
    }

    public void delete(Integer id) {
        Employee employee = selectById(id);
        if(employee != null)
            delete(employee);
    }

    public long count() {
        return (long) createEntityCriteria().setProjection(Projections.rowCount()).uniqueResult();
    }
}
