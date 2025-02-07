package com.example.transactionmanagementdemo.repository;

import com.example.transactionmanagementdemo.entity.EmployeeCascadePersist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepository extends JpaRepository<EmployeeCascadePersist,Long> {

}
