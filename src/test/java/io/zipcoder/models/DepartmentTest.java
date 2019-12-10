package io.zipcoder.models;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentTest {
    @Test
    public void setDepartmentNameTest() {
        Department department = new Department();

        department.setDepartmentName("Apparel");

        Assert.assertEquals("Apparel", department.getDepartmentName());
    }

    @Test
    public void setDepartmentManagerTest() {
        Department department = new Department();
        Employee manager = new Employee();

        department.setDepartmentManager(manager);

        Assert.assertEquals(manager, department.getDepartmentManager());
    }
}
