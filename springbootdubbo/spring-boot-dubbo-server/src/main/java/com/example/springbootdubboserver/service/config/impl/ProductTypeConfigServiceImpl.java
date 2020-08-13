package com.example.springbootdubboserver.service.config.impl;

import com.example.springbootdubboserver.entity.config.ProductTypeConfig;
import com.example.springbootdubboserver.repository.config.ProductTypeConfigRepository;
import com.example.springbootdubboserver.service.base.BaseRepository;
import com.example.springbootdubboserver.service.base.BaseService;
import com.example.springbootdubboserver.service.config.ProductTypeConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductTypeConfigServiceImpl extends BaseService<ProductTypeConfig> implements ProductTypeConfigService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductTypeConfigRepository productTypeConfigRepository;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    protected BaseRepository<ProductTypeConfig> getDAOInterface() {
        return productTypeConfigRepository;
    }
}
