package com.pro.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.springdatajpa.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long id);
    List<Employee> deleteByDesignation(String designation);
    Employee findTopByDesignationOrderBySalaryDesc(String designation);
}
