package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeService (EmployeeRepository repository){
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    public Employee readEmployee(Long id){
        return repository.getOne(id);
    }

    public Employee updateEmployee (Long id, Employee employee){
        Employee originalEmployee = repository.getOne(id);
        originalEmployee.setFirstName(employee.getFirstName());
        originalEmployee.setLastName(employee.getLastName());
        originalEmployee.setTitle(employee.getTitle());
        originalEmployee.setPhoneNumber(employee.getPhoneNumber());
        originalEmployee.setEmail(employee.getEmail());
        originalEmployee.setHireDate(employee.getHireDate());
        originalEmployee.setManager(employee.getManager());
        return repository.save(originalEmployee);
    }

    public Boolean deleteEmployee (Long id){
        repository.delete(id);
        return true;
    }
}
