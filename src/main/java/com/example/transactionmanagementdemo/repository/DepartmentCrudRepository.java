package com.example.transactionmanagementdemo.repository;

import com.example.transactionmanagementdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentCrudRepository extends JpaRepository<Department,Long> {
}
