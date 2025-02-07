package com.example.transactionmanagementdemo.repository;

import com.example.transactionmanagementdemo.entity.MetaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaInfoRepository extends JpaRepository<MetaInfo,Long> {

}
