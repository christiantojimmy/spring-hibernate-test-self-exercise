package com.research.spring.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jimmy
 * @date 2017-01-19 12:46 PM
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double salary;
    private Date started_work;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Employee() {
    }

    public Employee(String name, double salary, Date started_work) {
        this.name = name;
        this.salary = salary;
        this.started_work = started_work;
    }

    public Employee(String name, double salary, Date started_work, Company company) {
        this.name = name;
        this.salary = salary;
        this.started_work = started_work;
        this.company = company;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStarted_work() {
        return started_work;
    }

    public void setStarted_work(Date started_work) {
        this.started_work = started_work;
    }
}
