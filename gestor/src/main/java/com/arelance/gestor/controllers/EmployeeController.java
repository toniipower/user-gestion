package com.arelance.gestor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arelance.gestor.entities.Employee;
import com.arelance.gestor.services.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }


    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }
}
