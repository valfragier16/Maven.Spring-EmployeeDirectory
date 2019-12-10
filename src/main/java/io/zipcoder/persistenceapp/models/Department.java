package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Employee departmentManager;


    // Nullary Constructor
    public Department(){

    }

    public Department(String departmentName, Employee departmentManager){
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }
}
