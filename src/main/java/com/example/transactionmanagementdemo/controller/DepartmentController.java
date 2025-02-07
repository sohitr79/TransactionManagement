package com.example.transactionmanagementdemo.controller;

import com.example.transactionmanagementdemo.entity.Department;
import com.example.transactionmanagementdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Void> addDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
