package com.example.springbootdubboserver.service.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public abstract class BaseService<T> implements ServiceInterface<T> {

    private Class<T> clazz;

    /**
     * 实体管理器引用
     * 
     * @return EntityManager
     */
    protected abstract EntityManager getEntityManager();

    /**
     * DAO接口引用
     * 
     * @return DAOInterface<T>
     */
    protected abstract BaseRepository<T> getDAOInterface();

    /**
     * 构造函数反射泛型对象真实类型
     */
    @SuppressWarnings("unchecked")
    public BaseService() {
        // 获取当前new的对象的泛型父类
        ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取类型参数的真是值，就是泛型参数的个数；
        this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
    }

    @Override
    public T find(Long id) throws Exception {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public T save(T t) throws Exception {
        T save = getDAOInterface().save(t);
        return save;
    }

    @Override
    public T update(T t) throws Exception {
       T update = getEntityManager().merge(t);
       return update;
    }

    @Override
    public void del(Long id) throws Exception {
        T t = getEntityManager().find(clazz, id);
        if (t != null) {
            getEntityManager().remove(t);
        }
    }

    @Override
    public List<T> findAll() throws Exception {
        return getDAOInterface().findAll();
    }

}
