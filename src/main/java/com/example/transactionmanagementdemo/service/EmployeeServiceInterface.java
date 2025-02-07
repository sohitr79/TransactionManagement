package com.example.transactionmanagementdemo.service;

import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    ResponseEntity<String> addEmployeeWithCascade(EmployeeCascadePersist employeeCascadePersist);

    List<EmployeeCascadePersist> getAllEmployee();

    EmployeeCascadePersist getEmployeeById(long id);

    void deleteEmployeeById(long id);
}
