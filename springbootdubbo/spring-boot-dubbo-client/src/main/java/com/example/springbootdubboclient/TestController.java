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
    //loadbalance:random,roundrobin,一致性hash hash 环， 0~2^23-1,并添加虚拟节点
    @DubboReference(registry = {"shanghai","beijing"} ,protocol = "dubbo",loadbalance = "random",version = "V2.0")
    ILoginService loginService;

    @GetMapping("/login")
    public String login(){
        return loginService.login("joe","123");
    }
}
