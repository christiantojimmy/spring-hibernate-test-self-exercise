package com.research.spring.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author jimmy
 * @date 2017-01-19 1:34 PM
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
