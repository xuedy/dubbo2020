package com.example.springbootdubboserver.repository.config;

import com.example.springbootdubboserver.entity.config.ProductConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductConfigRepository extends JpaRepository<ProductConfig,Long> {

}
