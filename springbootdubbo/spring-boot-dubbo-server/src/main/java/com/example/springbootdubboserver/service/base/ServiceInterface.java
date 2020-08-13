package com.example.springbootdubboserver.service.base;

import java.util.List;


public interface ServiceInterface<T> {

    /**
     * 添加
     * 
     * @param t
     * @return T
     * @throws Exception
     *             添加异常
     */
    public T save(T t) throws Exception;

    /**
     * 修改
     * 
     * @param t
     * @return T
     * @throws Exception
     *             修改异常
     */
    public T update(T t) throws Exception;

    /**
     * 删除
     * 
     * @param id
     * @throws Exception
     *             删除异常
     */
    public void del(Long id) throws Exception;

    /**
     * 查询单个
     * 
     * @param id
     * @return T
     * @throws Exception
     *             查询单个异常
     */
    public T find(Long id) throws Exception;

    /**
     * 查询所有
     * 
     * @return List<T>
     * @throws Exception
     *             查询列表异常
     */
    public List<T> findAll() throws Exception;

}
