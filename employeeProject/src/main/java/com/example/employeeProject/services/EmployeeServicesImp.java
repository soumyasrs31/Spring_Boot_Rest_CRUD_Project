package com.example.employeeProject.services;

import com.example.employeeProject.dao.EmployeeDAO;
import com.example.employeeProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServicesImp implements EmployeeServices{

    //define field for employeeDAO

    private EmployeeDAO employeeDAO;

    //constructor injection

    @Autowired
    public EmployeeServicesImp(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {

        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }


}
