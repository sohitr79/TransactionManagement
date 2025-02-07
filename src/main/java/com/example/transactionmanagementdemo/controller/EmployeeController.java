package com.example.transactionmanagementdemo.controller;

import com.example.transactionmanagementdemo.entity.Employee;
import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import com.example.transactionmanagementdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Void> addEmployeeWithCascade(@RequestBody EmployeeCascadePersist employeeCascadePersist) {

        employeeService.addEmployeeWithCascade(employeeCascadePersist);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/save/transactional")
    public ResponseEntity<Void> addEmployeeWithTransactional(@RequestBody Employee employee) {

        employeeService.addEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeCascadePersist>> getAllEmployee() {
        List<EmployeeCascadePersist> employeeCascadePersistList = employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeCascadePersist>>(employeeCascadePersistList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeCascadePersist> getEmployeeById(@PathVariable long id){

        EmployeeCascadePersist employeeCascadePersist = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeCascadePersist>(employeeCascadePersist,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable long id){
         employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeCascadePersist employeeCascadePersist){
        employeeService.addEmployeeWithCascade(employeeCascadePersist);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
