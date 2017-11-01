package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul网关
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServer 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulServer.class, args);
    }
}
