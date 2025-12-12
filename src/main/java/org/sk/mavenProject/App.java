package org.sk.mavenProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) {
        System.out.println("Welcome to Department Employee Management System");
        System.out.println("Enter the Name of the Department:");
        String departmentName = sc.next();
        Departments department = new Departments(departmentName);
        List<Employees> employees = addEmployees(new ArrayList<>());
        department.setEmployees(employees);
        for(Employees employee : employees) {
            employee.setDepartment(department);
        }
        
        // Hibernate code to persist department and employees would go here
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.persist(department);
        
        transaction.commit();
        session.close();
        factory.close();
        System.out.println("Data saved successfully");
        sc.close();
    
    }
    
    public static List<Employees> addEmployees(List<Employees> employees) {
        System.out.println("Enter number of employees to add: ");
        int noOfEmployees = sc.nextInt();
        for (int i = 0; i < noOfEmployees; i++) {
            System.out.println("Enter employee name: ");
            String employeeName = sc.next();
            Employees employee = new Employees(employeeName);
            employees.add(employee);
        }
        return employees;
    }
}
