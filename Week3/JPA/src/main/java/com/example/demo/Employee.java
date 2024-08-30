package com.example.demo;

import jakarta.persistence.*;


@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="salary")
    private double salary;

    @Column(name="department")
    private String department;

    Employee() {

    }

    Employee(String first_name, String last_name, String email, double salary, String department) {
        this.department = department;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
