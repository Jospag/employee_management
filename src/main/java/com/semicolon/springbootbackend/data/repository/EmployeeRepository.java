package com.semicolon.springbootbackend.data.repository;

import com.semicolon.springbootbackend.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Employee entity.
 * Provides CRUD operations and custom queries for Employee entities.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    /**
     * Find employees by first name containing the given keyword (case insensitive).
     *
     * @param keyword the keyword to search for
     * @return list of matching employees
     */
    List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
    
    /**
     * Find employees by last name containing the given keyword (case insensitive).
     *
     * @param keyword the keyword to search for
     * @return list of matching employees
     */
    List<Employee> findByLastNameContainingIgnoreCase(String keyword);
    
    /**
     * Find employees by email containing the given keyword (case insensitive).
     *
     * @param keyword the keyword to search for
     * @return list of matching employees
     */
    List<Employee> findByEmailContainingIgnoreCase(String keyword);
    
    /**
     * Find employees by first name, last name, or email containing the given keyword (case insensitive).
     *
     * @param keyword the keyword to search for
     * @return list of matching employees
     */
    @Query("SELECT e FROM Employee e WHERE " +
           "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> searchByKeyword(@Param("keyword") String keyword);
}
