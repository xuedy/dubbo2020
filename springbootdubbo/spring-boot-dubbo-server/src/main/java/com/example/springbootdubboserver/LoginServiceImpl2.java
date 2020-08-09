package com.example.springbootdubboserver;


import org.apache.dubbo.config.annotation.DubboService;
import org.example.ILoginService;

/**
 * @author Administrator
 * @className LoginServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
@DubboService(registry = {"shanghai","beijing"} ,version="V2.0")
public class LoginServiceImpl2 implements ILoginService {
    @Override
    public String login(String name, String password) {
        return name+" Login SUCCESS V2.0";
    }
}
