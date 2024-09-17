package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class Controller {

    @Autowired
    private Repository repository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        repository.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee temp = repository.save(employee);
        return temp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee temp = repository.findById(id).get();
        repository.delete(temp);
        return id + " Record Deleted";
    }



}
