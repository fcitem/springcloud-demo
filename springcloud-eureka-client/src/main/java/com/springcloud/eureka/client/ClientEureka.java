package com.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**创建服务提供者
 * 通过注解@EnableEurekaClient 表明自己是一个eurekaclient
 * @author fengchao
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
/*
 * 不能命名为EurekaClient,否则因为同名会报错
 */
public class ClientEureka 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ClientEureka.class, args);
    }
}
