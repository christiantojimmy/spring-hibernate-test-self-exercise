package com.research.spring.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.research.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author jimmy
 * @date 2017-01-20 11:11 AM
 */
public class EmployeeDaoImplTest extends EntityDaoImplTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testSelectAll() {
        assertThat(employeeDao.selectAll(), is(notNullValue()));
    }

    @Test
    public void testSelectById() {
        assertThat(employeeDao.selectById(1), is(notNullValue()));
    }

    @Test
    public void testInsert() {
        long firstCount = employeeDao.count();
        Employee employee = new Employee("WGS New Employee", 50000.0, new Date(), companyDao.selectById(1));
        employeeDao.insert(employee);

        assertThat(employeeDao.count(), is(firstCount + 1));
    }

    @Test
    public void testDelete() {
        employeeDao.delete(1);
        assertThat(employeeDao.selectById(1), is(nullValue()));
    }

    @Test
    public void testCount() {
        assertThat(employeeDao.count(), greaterThan(0L));
    }


}
