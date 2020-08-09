package com.example.springcloulddubboserver;


import org.apache.dubbo.config.annotation.Service;
import org.example.ILoginService;

/**
 * @author Administrator
 * @className LoginServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public String login(String name, String password) {
        return name+" Login SUCCESS";
    }
}
