package com.example.springbootdubboclient;


import org.example.ILoginService;

/**
 * @author Administrator
 * @className MockSayHelloService
 * @description TODO
 * @date {DATE}{TIME}
 */
public class MockLoginService implements ILoginService {
    @Override
    public String login(String name, String password) {
        return "出发熔断";
    }
}
