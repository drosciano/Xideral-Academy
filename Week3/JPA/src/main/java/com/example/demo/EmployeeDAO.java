package com.example.demo;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findByLastName(String last_name);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(Integer id);
    int deleteAll();
}
