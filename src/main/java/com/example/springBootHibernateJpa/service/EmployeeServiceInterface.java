package com.example.springBootHibernateJpa.service;

import com.example.springBootHibernateJpa.entity.EmployeeCascadePersist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    ResponseEntity<String> addEmployeeWithCascade(EmployeeCascadePersist employeeCascadePersist);

    List<EmployeeCascadePersist> getAllEmployee();

    EmployeeCascadePersist getEmployeeById(long id);

    void deleteEmployeeById(long id);
}
