package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;


    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @PostMapping("/employees/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> read(@PathVariable Long id){
        return new ResponseEntity<>(service.readEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteEmployee(id), HttpStatus.OK);
    }
}
