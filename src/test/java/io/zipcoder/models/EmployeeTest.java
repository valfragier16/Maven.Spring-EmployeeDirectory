package io.zipcoder.models;

import io.zipcoder.persistenceapp.models.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {

    @Test
    public void setFirstNameTest() {
        Employee employee = new Employee();

        employee.setFirstName("Valerie");

        Assert.assertEquals("Valerie", employee.getFirstName());
    }

    @Test
    public void setLastName() {
        Employee employee = new Employee();

        employee.setLastName("Fragier");

        Assert.assertEquals("Fragier", employee.getLastName());
    }

    @Test
    public void setTitle() {
        Employee employee = new Employee();

        employee.setTitle("Boss");

        Assert.assertEquals("Boss", employee.getTitle());
    }

    @Test
    public void setPhoneNumber() {
        Employee employee = new Employee();

        employee.setPhoneNumber("123-456-7890");

        Assert.assertEquals("123-456-7890", employee.getPhoneNumber());
    }

    @Test
    public void setEmail() {
        Employee employee = new Employee();

        employee.setEmail("val@gmail.com");

        Assert.assertEquals("val@gmail.com", employee.getEmail());
    }

    @Test
    public void setHireDate() {
        Employee employee = new Employee();
        Date date = new Date();
        employee.setHireDate(date);

        Assert.assertEquals(date, employee.getHireDate());
    }

    @Test
    public void setManager() {
        Employee employee = new Employee();
        Employee manager = new Employee();

        employee.setManager(manager);

        Assert.assertEquals(manager, employee.getManager());
    }

    @Test
    public void setDepartmentNumber() {
    }
}
