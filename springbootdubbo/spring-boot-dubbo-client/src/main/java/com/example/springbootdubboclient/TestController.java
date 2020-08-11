package com.example.springbootdubboclient;


import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.service.GenericService;
import org.example.ILoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.x509.IPAddressName;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @className TestController
 * @description TODO
 * @date {DATE}{TIME}
 */
@RestController
public class TestController {
    //1.loadbalance: 查看AbstractLoadBalance 的实现类
    // random；roundrobin；consistenthash一致性hash hash 环，0~2^23-1,并添加虚拟节点；最小活跃度；shortestreponse 最小响应时间;

    @DubboReference(registry = {"shanghai","beijing"} ,protocol = "dubbo", loadbalance = "consistenthash", check = false,methods={@Method(loadbalance = "random",name = "login")},version = "V2.0")
    ILoginService loginService;
    @DubboReference(interfaceName= "com.example.springbootdubboserver.SayService", check = false, generic = true)
     GenericService  genericService;

    @GetMapping("/login")
    public String login(){
        return loginService.login("joe","123");
    }

    @GetMapping("/say")
    public String say(){
        //如果参数是对象用map
        Map map =new HashMap();
        return genericService.$invoke("say",new String[0],null).toString();
    }
    /*IP绑定
     * 1.查找环境变量 如无转2
     * 2.读取配置文件 如无转3
     * 3.InetAddress 获取IP 如无 转4
     * 4.通过socket链接配置中心，获取IP
     * 5 轮询本机网卡
     * 6.如果还不是，用服务绑定Ip DUBBO_IP_TORE_REGESTRY
     **/

    /*配置优先级别
    * 1 如果级别一样，先客户端后服务端
    * 2.先方法，后接口，再配置，
    * */
}
