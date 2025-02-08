package com.example.transactionmanagementdemo.service;

import com.example.transactionmanagementdemo.entity.Department;
import com.example.transactionmanagementdemo.entity.MetaInfo;
import com.example.transactionmanagementdemo.repository.DepartmentCrudRepository;
import com.example.transactionmanagementdemo.repository.MetaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentCrudRepository departmentCrudRepository;

    @Autowired
    MetaInfoRepository metaInfoRepository;

    public Department saveDepartment(Department department) {
        return departmentCrudRepository.save(department); // Saves and returns the entity with generated ID
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveDepartmentWithTransaction(Department department) {
        departmentCrudRepository.save(department);
    }


//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMetaInfo(MetaInfo metaInfo) {
        metaInfoRepository.save(metaInfo);
    }
}

