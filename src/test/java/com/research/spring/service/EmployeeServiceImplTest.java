package com.research.spring.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.research.spring.dao.CompanyDao;
import com.research.spring.dao.EmployeeDao;
import com.research.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author jimmy
 * @date 2017-01-20 1:52 PM
 */
public class EmployeeServiceImplTest extends EntityServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSelectAll() throws Exception {
        assertThat(employeeService.selectAll(), is(notNullValue()));
    }

    @Test
    public void testSelectById() throws Exception {
        assertThat(employeeService.selectById(1), is(notNullValue()));
    }

    @Test
    public void testInsert() throws Exception {
        long actualCount = employeeDao.count();
        Employee employee = new Employee("New Employee", 50000.0, new Date(), companyService.selectById(1));
        employeeService.insert(employee);

        assertThat(employeeDao.count(), is(actualCount + 1));
    }

    @Test
    public void testUpdate() throws Exception {
        String expectedName = "New Name For Employee";
        Employee employee = employeeService.selectById(1);
        employee.setName(expectedName);
        employeeService.update(employee);

        employee = employeeService.selectById(1);
        String actualName = employee.getName();
        assertThat(actualName, equalTo(expectedName));
    }

    @Test
    public void testDelete() throws Exception {
        employeeService.delete(1);
        assertThat(employeeService.selectById(1), is(nullValue()));
    }

    @Test
    public void testCount() throws Exception {
        assertThat(employeeDao.count(), greaterThan(0L));
    }

}