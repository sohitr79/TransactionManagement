package com.example.transactionmanagementdemo.controller;

import com.example.transactionmanagementdemo.entity.Employee;
import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import com.example.transactionmanagementdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bank/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeCascadePersist> addEmployeeWithCascade(@RequestBody EmployeeCascadePersist employeeCascadePersist) {

        EmployeeCascadePersist employee = employeeService.addEmployeeWithCascade(employeeCascadePersist);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(employee);
    }

    @PostMapping("/save/transactional")
    public ResponseEntity<Employee> addEmployeeWithTransactional(@RequestBody Employee employee) {

       Employee createdEmployee = employeeService.addEmployee(employee);
       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(createdEmployee.getId())
               .toUri();
        return ResponseEntity.created(uri).body(createdEmployee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeCascadePersist>> getAllEmployee() {
        List<EmployeeCascadePersist> employeeCascadePersistList = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeCascadePersistList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeCascadePersist> getEmployeeById(@PathVariable long id) {

        EmployeeCascadePersist employeeCascadePersist = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeCascadePersist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeCascadePersist> deleteEmployeeById(@PathVariable long id) {
        EmployeeCascadePersist deletedEmployee = employeeService.deleteEmployeeById(id);
        return ResponseEntity.accepted().body(deletedEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeCascadePersist employeeCascadePersist) {
        employeeService.addEmployeeWithCascade(employeeCascadePersist);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
