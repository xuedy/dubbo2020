package org.example.service.Impl;

import org.example.service.ILoginService;

/**
 * @author Administrator
 * @className LoginServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
public class LoginServiceImpl implements ILoginService {
    @Override
    public String login(String name, String password) {
        return name+" Login SUCCESS";
    }
}
