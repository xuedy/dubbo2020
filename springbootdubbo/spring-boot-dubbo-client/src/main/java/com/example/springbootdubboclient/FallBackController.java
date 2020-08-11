package com.example.springbootdubboclient;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.ILoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @className FallBackController
 * @description TODO
 * @date {DATE}{TIME}
 */
@RestController
public class FallBackController {

    @DubboReference(
            registry = {"shanghai","beijing"} ,
            protocol = "dubbo",
            loadbalance = "consistenthash",
            mock = "com.example.springbootdubboclient.MockLoginService",
            timeout = 500,
            cluster = "failfast",
            check = false,
            version = "V2.0")
    ILoginService loginService;
    @GetMapping("/mock/login")
    public String login(){
        return loginService.login("joe","123");
    }
}
