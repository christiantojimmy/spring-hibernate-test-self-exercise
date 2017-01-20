package com.research.spring.controller;

import com.research.spring.model.Company;
import com.research.spring.model.Employee;
import com.research.spring.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 2:36 PM
 */
public class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @Mock
    private CompanyController companyController;

    @Spy
    List<Company> companies = new ArrayList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        companies = getCompanies();
    }

    @Test
    public void testAll() {
        Mockito.when(companyService.selectAll()).thenReturn(companies);
    }

    public List<Company> getCompanies() {
        Company company = new Company("WGS", "Software House");

        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("WGS Employee 1", 100000.0, new Date()));
            add(new Employee("WGS Employee 2", 100000.0, new Date()));
            add(new Employee("WGS Employee 3", 100000.0, new Date()));
            add(new Employee("WGS Employee 4", 100000.0, new Date()));
            add(new Employee("WGS Employee 5", 100000.0, new Date()));
        }};

        company.setEmployees(employees);

        List<Company> companies = new ArrayList<Company>() {{
            add(company);
        }};

        return companies;
    }
}
