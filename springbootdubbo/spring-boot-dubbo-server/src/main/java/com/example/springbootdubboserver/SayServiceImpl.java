package com.example.springbootdubboserver;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Administrator
 * @className SayServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
@DubboService(protocol ={"dubbo"} )
public class SayServiceImpl implements SayService {
    @Override
    public String say() {
        return "success";
    }
}
