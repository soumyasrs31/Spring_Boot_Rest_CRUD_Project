package com.example.employeeProject.dao;

import com.example.employeeProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set the constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //Create the query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        //Execute the query and get the result
        List<Employee> employees = theQuery.getResultList();

        //return the query
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //update employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //delete the employee
        entityManager.remove(theEmployee);
    }
}
