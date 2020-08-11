package com.example.springbootdubboserver;


import org.apache.dubbo.config.annotation.DubboService;
import org.example.ILoginService;

/**
 * @author Administrator
 * @className LoginServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
//2.集群容错
//cluster： Failover失败重试 reties=2 一共三次，重试两次；Failfast 快速失败；，failsafe失败安全，吞掉异常；failback 失败自动恢复，记录失败，定时重试；
// forking 并行调用多个服务区 ；broadcast广播调用，只要有一个失败就认为失败
@DubboService(registry = {"shanghai","beijing"} ,protocol = {"dubbo","rest"},cluster = "failover",retries = 3,version="V2.0")
public class LoginServiceImpl2 implements ILoginService {
    @Override
    public String login(String name, String password) {
        return name+" Login SUCCESS V2.0";
    }
}
