package com.research.spring.dao;

import com.research.spring.model.Company;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:49 PM
 */
@Repository
public class CompanyDaoimpl extends AbstractDao<Integer, Company> implements CompanyDao {

    public List<Company> selectAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Company>) criteria.list();
    }

    public Company selectById(Integer id) {
        return getByKey(id);
    }

    public void insert(Company item) {
        persist(item);
    }

    public void delete(Integer id) {
        Company company = selectById(id);
        if(company != null)
            delete(company);
    }

    public long count() {
        return (long) createEntityCriteria().setProjection(Projections.rowCount()).uniqueResult();
    }
}
