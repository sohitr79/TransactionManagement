package com.example.transactionmanagementdemo.service;

import com.example.transactionmanagementdemo.custom.exception.BusinessException;
import com.example.transactionmanagementdemo.custom.exception.EmptyInputException;
import com.example.transactionmanagementdemo.custom.exception.EmptyListException;
import com.example.transactionmanagementdemo.entity.Employee;
import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import com.example.transactionmanagementdemo.entity.MetaInfo;
import com.example.transactionmanagementdemo.repository.EmployeeCrudRepository;
import com.example.transactionmanagementdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EmployeeCascadePersist addEmployeeWithCascade(EmployeeCascadePersist employeeCascadePersist) {
        if (employeeCascadePersist.getName().isEmpty() || employeeCascadePersist.getName().length() == 0) {
            throw new EmptyInputException("601", "Please send proper name, It's blank");
        }
        return employeeCrudRepository.save(employeeCascadePersist);
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
    public EmployeeCascadePersist deleteEmployeeById(long id) {
        EmployeeCascadePersist deletedEmployee = employeeCrudRepository.getReferenceById(id);
        employeeCrudRepository.delete(deletedEmployee);
        return deletedEmployee;
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        validateEmployee(employee);

        //First save the Department then save employee

        departmentService.saveDepartmentWithTransaction(employee.getDepartment());


        Employee createdEmployee = employeeRepository.save(employee);

        MetaInfo metaInfo = new MetaInfo(employee.getName(), employee.getDepartment().getName());

        departmentService.saveMetaInfo(metaInfo);

        return createdEmployee;
    }

    private void validateEmployee(Employee employee) {

        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (employeeRepository.findByMobile(employee.getMobile()).isPresent()) {
            throw new BusinessException("408","Already registered Mobile Number");
        }
    }
}
