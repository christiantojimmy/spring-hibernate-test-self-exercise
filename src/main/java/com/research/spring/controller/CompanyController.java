package com.research.spring.controller;

import com.research.spring.model.Company;
import com.research.spring.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:46 PM
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<Company> all() {
        return companyService.selectAll();
    }
}
