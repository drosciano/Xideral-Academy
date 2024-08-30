package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    @Transactional
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findByLastName(String last_name) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "FROM Employee WHERE last_name=:theData", Employee.class);

        query.setParameter("theData", last_name);

        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Employee").executeUpdate(); //<==JPA

        return numRowsDeleted;
    }
}
