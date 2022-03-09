package com.semicolon.springbootbackend.data.repository;

import com.semicolon.springbootbackend.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
