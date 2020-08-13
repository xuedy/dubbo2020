package com.example.springbootdubboserver.repository.config;

import com.example.springbootdubboserver.entity.config.CoverageConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoverageConfigRepository extends JpaRepository<CoverageConfig,Long> {
}
