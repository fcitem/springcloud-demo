package com.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**创建服务提供者
 * 通过注解@EnableEurekaClient 表明自己是一个eurekaclient
 * @author fengchao
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Client.class, args);
    }
}
