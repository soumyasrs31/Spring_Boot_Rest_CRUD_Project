package com.example.employeeProject.rest;

import com.example.employeeProject.dao.EmployeeDAO;
import com.example.employeeProject.entity.Employee;
import com.example.employeeProject.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //define field for EmployeeService interface

    private EmployeeServices employeeServices;

    //constructor injection

    @Autowired
    public EmployeeRestController(EmployeeServices theEmployeeServices){
        this.employeeServices = theEmployeeServices;
    }

    //define endpoint access

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeServices.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeServices.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("ID isnot exit :"+ employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //Here we have to add setId because if there is no element then the data is keep as first element so we set as o its value
        theEmployee.setId(0);
        Employee dbEmployee = employeeServices.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeServices.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeServices.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Id is not found "+employeeId);
        }
        employeeServices.deleteById(employeeId);
        return "Deleted successfully :"+employeeId;
    }
}
