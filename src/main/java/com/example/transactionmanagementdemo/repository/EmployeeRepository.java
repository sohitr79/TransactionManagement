package com.example.transactionmanagementdemo.repository;

import com.example.transactionmanagementdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByMobile(Integer mobile);
}
