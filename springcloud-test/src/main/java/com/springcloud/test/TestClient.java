package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**创建服务提供者
 * 通过注解@EnableEurekaClient 表明自己是一个服务提供者
 * @author fengchao
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
/*
 * 如果其它bean不在主程序的子包下则需要显示指明basePackage位置
 */
@ComponentScan(basePackages="com.springcloud.test")
public class TestClient
{
    public static void main( String[] args )
    {
        SpringApplication.run(TestClient.class, args);
    }
}
