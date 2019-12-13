package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByManagerId(long managerId);

    List<Employee> findEmployeeByDepartmentNum(long departmentId);

    List<Employee> findEmployeeByManagerIsNull();

    void deleteEmployeesByDepartmentNum(long departmentId);

    void deleteEmployeesByManagerIn(Iterable<Employee> managers);

}
