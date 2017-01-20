package com.research.spring.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.research.spring.model.Company;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.logging.Logger;


/**
 * @author jimmy
 * @date 2017-01-19 3:27 PM
 */
public class CompanyDaoImplTest extends EntityDaoImplTest {

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testSelectAll() {
        assertThat(companyDao.selectAll(), is(notNullValue()));
    }

    @Test
    public void testSelectById() {
        assertThat(companyDao.selectById(1), is(notNullValue()));
    }

    @Test
    public void testInsert() {
        long firstCount = companyDao.count();
        companyDao.insert(new Company("Appschef", "Software House"));
        assertThat(companyDao.count(), is(firstCount + 1));
    }

    @Test
    public void testDelete() {
        companyDao.delete(1);
        assertThat(companyDao.selectById(1), is(nullValue()));
    }

    @Test
    public void testCount() {
        assertThat(companyDao.count(), greaterThan(0L));
    }
}
