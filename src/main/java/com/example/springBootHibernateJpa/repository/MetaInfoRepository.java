package com.example.springBootHibernateJpa.repository;

import com.example.springBootHibernateJpa.entity.Employee;
import com.example.springBootHibernateJpa.entity.MetaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaInfoRepository extends JpaRepository<MetaInfo,Long> {

}
