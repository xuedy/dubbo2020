package com.example.springbootdubboserver.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 系统从参数配置类
 * @author qsnp236
 *
 */
@Configuration
public class SysProperties {
	public static String IV="NXI5ETSD3ZGYH6DS";
    @Value("${service.system.aes-key}")
    public static String AES_KEY;
}