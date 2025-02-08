package com.example.transactionmanagementdemo.service;

import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;

import java.util.List;

public interface EmployeeServiceInterface {
   EmployeeCascadePersist addEmployeeWithCascade(EmployeeCascadePersist employeeCascadePersist);

    List<EmployeeCascadePersist> getAllEmployee();

    EmployeeCascadePersist getEmployeeById(long id);

    EmployeeCascadePersist deleteEmployeeById(long id);
}
