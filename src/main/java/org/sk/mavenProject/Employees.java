package org.sk.mavenProject;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    
    @Column
    private String employee_name;
    
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Departments department;
    
    public Employees() {
    }
    
    public Employees(int employee_id, String employee_name, Departments department) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.department = department;
    }
    
    public Employees(String employee_name, Departments department) {
        this.employee_name = employee_name;
        this.department = department;
    }
    
    public Employees(String employee_name) {
        this.employee_name = employee_name;
    }
    
    public int getEmployee_id() {
        return employee_id;
    }
    
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
    
    public String getEmployee_name() {
        return employee_name;
    }
    
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    
    public Departments getDepartment() {
        return department;
    }
    
    public void setDepartment(Departments department) {
        this.department = department;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        
        Employees employees = (Employees) o;
        return employee_id == employees.employee_id && Objects.equals(employee_name, employees.employee_name) && Objects.equals(department, employees.department);
    }
    
    @Override
    public int hashCode() {
        int result = employee_id;
        result = 31 * result + Objects.hashCode(employee_name);
        result = 31 * result + Objects.hashCode(department);
        return result;
    }
    
    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", department=" + department +
                '}';
    }
}
