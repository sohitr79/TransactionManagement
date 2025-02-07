package com.example.transactionmanagementdemo.service;

import com.example.transactionmanagementdemo.custom.exception.EmptyInputException;
import com.example.transactionmanagementdemo.custom.exception.EmptyListException;
import com.example.transactionmanagementdemo.entity.Employee;
import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import com.example.transactionmanagementdemo.entity.MetaInfo;
import com.example.transactionmanagementdemo.repository.EmployeeCrudRepository;
import com.example.transactionmanagementdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeCrudRepository employeeCrudRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentService departmentService;

    @Override
    public ResponseEntity<String> addEmployeeWithCascade(EmployeeCascadePersist employeeCascadePersist) {
        if (employeeCascadePersist.getName().isEmpty() || employeeCascadePersist.getName().length() == 0) {
            throw new EmptyInputException("601", "Please send proper name, It's blank");
        }
        employeeCrudRepository.save(employeeCascadePersist);
        return ResponseEntity.ok("Employee saved successfully");
    }

    @Override
    public List<EmployeeCascadePersist> getAllEmployee() {
        List<EmployeeCascadePersist> employeeCascadePersistList = employeeCrudRepository.findAll();
        if (employeeCascadePersistList.isEmpty()) {
            throw new EmptyListException("602", "There are no records in the database");
        }
        return employeeCascadePersistList;
    }

    @Override
    public EmployeeCascadePersist getEmployeeById(long id) {
        return employeeCrudRepository.getReferenceById((id));
    }

    @Override
    public void deleteEmployeeById(long id) {
        EmployeeCascadePersist employeeCascadePersist = employeeCrudRepository.getReferenceById(id);
        employeeCrudRepository.delete(employeeCascadePersist);
    }

    @Transactional
    public ResponseEntity<String> addEmployee(Employee employee) {
        if (employee.getName().isEmpty() || employee.getName().length() == 0) {
            throw new EmptyInputException("601", "Please send proper name, It's blank");
        }
        //First save the Department then save employee

        departmentService.saveDepartmentWithTransaction(employee.getDepartment());


        employeeRepository.save(employee);

        MetaInfo metaInfo = new MetaInfo(employee.getName(), employee.getDepartment().getName());

        departmentService.saveMetaInfo(metaInfo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
