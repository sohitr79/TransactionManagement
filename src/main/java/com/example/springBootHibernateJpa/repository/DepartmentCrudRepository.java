package com.example.springBootHibernateJpa.repository;

import com.example.springBootHibernateJpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentCrudRepository extends JpaRepository<Department,Long> {
}
