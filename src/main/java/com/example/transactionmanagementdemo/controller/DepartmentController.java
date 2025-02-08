package com.example.transactionmanagementdemo.controller;

import com.example.transactionmanagementdemo.entity.Department;
import com.example.transactionmanagementdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bank/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> addDepartment(@RequestBody @Validated Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDepartment.getDepartmentId())
                .toUri();
        return ResponseEntity.created(location).body(savedDepartment);
    }
}
