package com.research.spring.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.research.spring.dao.CompanyDao;
import com.research.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author jimmy
 * @date 2017-01-20 11:33 AM
 */
public class CompanyServiceImplTest extends EntityServiceImplTest {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testSelectAll() {
        assertThat(companyService.selectAll(), is(notNullValue()));
    }

    @Test
    public void testSelectById() {
        assertThat(companyService.selectById(1), is(notNullValue()));
    }

    @Test
    public void testInsert() {
        long firstCount = companyDao.count();
        companyService.insert(new Company("Appschef", "Software House"));
        assertThat(companyDao.count(), is(firstCount + 1));
    }

    @Test
    public void testUpdate() {
        String expectedName = "WGS Edited";
        Company company = companyService.selectById(1);
        company.setName(expectedName);
        companyService.update(company);

        company = companyService.selectById(1);
        String actualName = company.getName();

        assertThat(actualName, equalTo(expectedName));
    }

    @Test
    public void testDelete() {
        companyService.delete(1);
        assertThat(companyService.selectById(1), is(nullValue()));
    }

    @Test
    public void testCount() {
        assertThat(companyDao.count(), greaterThan(0L));
    }

}