package com.research.spring.service;

import com.research.spring.dao.CompanyDao;
import com.research.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:48 PM
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public List<Company> selectAll() {
        return companyDao.selectAll();
    }

    public Company selectById(Integer id) {
        return companyDao.selectById(id);
    }

    public void insert(Company item) {
        companyDao.insert(item);
    }

    public void update(Company item) {
        Company company = selectById(item.getId());
        if (company != null) {
            company.setName(item.getName());
            company.setDescription(item.getDescription());
            company.setEmployees(item.getEmployees());
        }
    }

    public void delete(Integer id) {
        companyDao.delete(id);
    }
}
