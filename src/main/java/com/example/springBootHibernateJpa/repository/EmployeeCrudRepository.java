package com.example.springBootHibernateJpa.repository;

import com.example.springBootHibernateJpa.entity.EmployeeCascadePersist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepository extends JpaRepository<EmployeeCascadePersist,Long> {

}
