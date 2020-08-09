package com.example.springclouddubboclient;


import org.apache.dubbo.config.annotation.Reference;
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
    @Reference
    ILoginService loginService;

    @GetMapping("/login")
    public String login(){
        return loginService.login("joe","123");
    }
}
