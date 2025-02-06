package com.example.springBootHibernateJpa.service;

import com.example.springBootHibernateJpa.entity.Department;
import com.example.springBootHibernateJpa.entity.MetaInfo;
import com.example.springBootHibernateJpa.repository.DepartmentCrudRepository;
import com.example.springBootHibernateJpa.repository.MetaInfoRepository;
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

    public void saveDepartment(Department department) {
        departmentCrudRepository.save(department);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveDepartmentWithTransaction(Department department) {
        departmentCrudRepository.save(department);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void saveDepartmentReqNewProp(Department department) {
//        departmentCrudRepository.save(department);
//    }

//    @Transactional(propagation = Propagation.NESTED)
//    public void saveDepartmentNesProp(Department department) {
//        departmentCrudRepository.save(department);
//    }
//
//    @Transactional(propagation = Propagation.MANDATORY)
//    public void saveDepartmentManProp(Department department) {
//        departmentCrudRepository.save(department);
//    }
//
//    @Transactional(propagation = Propagation.NEVER)
//    public void saveDepartmentNevProp(Department department) {
//        departmentCrudRepository.save(department);
//    }
//
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public void saveDepartmentNotSupported(Department department) {
//        departmentCrudRepository.save(department);
//    }
//
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void saveDepartmentSuppProp(Department department) {
//        departmentCrudRepository.save(department);
//    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMetaInfo(MetaInfo metaInfo) {
        metaInfoRepository.save(metaInfo);
    }
}

