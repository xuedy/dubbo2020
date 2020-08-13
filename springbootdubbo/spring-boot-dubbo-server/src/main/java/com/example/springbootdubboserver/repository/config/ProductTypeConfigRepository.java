package com.example.springbootdubboserver.repository.config;


import com.example.springbootdubboserver.entity.config.ProductTypeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeConfigRepository extends JpaRepository<ProductTypeConfig,Long> {

}
