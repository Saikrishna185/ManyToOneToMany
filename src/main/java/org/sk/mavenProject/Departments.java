package org.sk.mavenProject;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    
    @Column
    private String department_name;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    List<Employees> employees;
    
    public Departments() {
    }
    
    public Departments(int department_id, String department_name, List<Employees> employees) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.employees = employees;
    }
    
    public Departments(String department_name, List<Employees> employees) {
        this.department_name = department_name;
        this.employees = employees;
    }
    
    public Departments(String department_name) {
        this.department_name = department_name;
    }
    
    public int getDepartment_id() {
        return department_id;
    }
    
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    
    public String getDepartment_name() {
        return department_name;
    }
    
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    
    public List<Employees> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return department_id == that.department_id && Objects.equals(department_name, that.department_name) && Objects.equals(employees, that.employees);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(department_id, department_name, employees);
    }
    
    @Override
    public String toString() {
        return "Departments{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
