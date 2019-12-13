package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findOne(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepository.delete(id);
    }

    public void deleteEmployees(List<Employee> employees) {
        employeeRepository.delete(employees);
    }

    public void deleteEmployeesFromDepartment(long deptId) {
        employeeRepository.deleteEmployeesByDepartmentNum(deptId);
    }

    public void deleteEmployeesManagedByRecursive(long managerId) {
        Employee manager = getEmployee(managerId);
        if (manager != null) {
            List<Employee> toBeDeleted = new ArrayList<Employee>((List<Employee>) getEmployeesManagedBy(managerId));
            while (toBeDeleted.size() > 0) {
                List<Employee> nextBatch = new ArrayList<>();
                for (Employee e: toBeDeleted) {
                    nextBatch.addAll((List<Employee>) getEmployeesManagedBy(e.getId()));
                    nextBatch.stream().forEach(em -> em.setManager(null));
                    employeeRepository.delete(e);
                }
                toBeDeleted.clear();
                toBeDeleted.addAll(nextBatch);
            }
        }
    }

    public void deleteEmployeesManagedByRemap(long managerId) {
        Employee manager = getEmployee(managerId);

        if (manager != null) {
            Employee nextManager = manager.getManager(); // remap employees to this manager
            Iterable<Employee> employees = getEmployeesManagedBy(managerId);

            for (Employee e: employees) { // loop through, remapping them
                for (Employee ee : employeeRepository.findEmployeeByManagerId(e.getId())) {
                    ee.setManager(nextManager);
                }
                deleteEmployee(e.getId());
            }
            deleteEmployee(managerId);
        }
    }


    public Employee setManager(long id, long managerId) {
        Employee employee = getEmployee(id);
        Employee manager = getEmployee(managerId);
        if (employee != null && manager != null) {
            employee.setManager(manager);
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> getEmployeesManagedBy (long managerId) {
        return employeeRepository.findEmployeeByManagerId(managerId);
    }

    public Iterable<Employee> getEmployeesOfDepartment (long deptId) {
        return employeeRepository.findEmployeeByDepartmentNum(deptId);
    }

    public Iterable<Employee> getEmployeesNoManager () {
        return employeeRepository.findEmployeeByManagerIsNull();
    }

    public Iterable<Employee> getManagerTree(long employeeId) {
        Employee employee = getEmployee(employeeId);
        List<Employee> managers = new ArrayList<>();
        Employee current = employee;
        while (current.getManager() != null) {
            current = current.getManager();
            managers.add(current);
        }
        return managers;
    }
}
