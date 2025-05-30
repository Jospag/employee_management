package com.semicolon.springbootbackend.service;

import com.semicolon.springbootbackend.data.model.Employee;
import java.util.List;

/**
 * Service interface for managing Employee entities.
 */
public interface EmployeeService {
    
    /**
     * Retrieves all employees from the database.
     *
     * @return List of all employees
     */
    List<Employee> getAllEmployees();
    
    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve
     * @return The employee if found
     */
    Employee getEmployeeById(Long id);
    
    /**
     * Creates a new employee.
     *
     * @param employee The employee entity to create
     * @return The created employee with generated ID
     */
    Employee createEmployee(Employee employee);
    
    /**
     * Updates an existing employee.
     *
     * @param id The ID of the employee to update
     * @param employeeDetails The updated employee details
     * @return The updated employee
     */
    Employee updateEmployee(Long id, Employee employeeDetails);
    
    /**
     * Deletes an employee by their ID.
     *
     * @param id The ID of the employee to delete
     * @return true if deletion was successful
     */
    boolean deleteEmployee(Long id);
    
    /**
     * Searches for employees by name or email.
     *
     * @param keyword The search keyword
     * @return List of employees matching the search criteria
     */
    List<Employee> searchEmployees(String keyword);
}
