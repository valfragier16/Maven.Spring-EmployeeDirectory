package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeService employeeService;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(long id) {
        return departmentRepository.findOne(id);
    }

    public Department setManager(long id, long managerId) {
        Department department = getDepartment(id);
        Employee manager = employeeService.getEmployee(managerId);
        if (department != null && manager != null) {
            department.setDepartmentManager(manager);
            return departmentRepository.save(department);
        } else {
            return null;
        }
    }
}
