package com.semicolon.springbootbackend.controller;

import com.semicolon.springbootbackend.data.model.Employee;
import com.semicolon.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Employee resources.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * GET /api/employees : Get all employees
     *
     * @return the ResponseEntity with status 200 (OK) and the list of employees in the body
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * GET /api/employees/:id : Get employee by id
     *
     * @param id the id of the employee to retrieve
     * @return the ResponseEntity with status 200 (OK) and the employee in the body
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * POST /api/employees : Create a new employee
     *
     * @param employee the employee to create
     * @return the ResponseEntity with status 201 (Created) and the new employee in the body
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * PUT /api/employees/:id : Update an existing employee
     *
     * @param id the id of the employee to update
     * @param employeeDetails the employee details to update
     * @return the ResponseEntity with status 200 (OK) and the updated employee in the body
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    /**
     * DELETE /api/employees/:id : Delete an employee
     *
     * @param id the id of the employee to delete
     * @return the ResponseEntity with status 200 (OK) and deletion confirmation message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * GET /api/employees/search : Search employees by keyword
     *
     * @param keyword the search keyword
     * @return the ResponseEntity with status 200 (OK) and the list of matching employees in the body
     */
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String keyword) {
        List<Employee> employees = employeeService.searchEmployees(keyword);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
