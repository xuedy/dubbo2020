package com.example.springbootdubboclient;


import org.apache.dubbo.config.annotation.DubboReference;
import org.example.ILoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @className TestController
 * @description TODO
 * @date {DATE}{TIME}
 */
@RestController
public class TestController {

    @DubboReference(registry = {"shanghai","beijing"} ,version = "V2.0")
    ILoginService loginService;

    @GetMapping("/login")
    public String login(){
        return loginService.login("joe","123");
    }
}
