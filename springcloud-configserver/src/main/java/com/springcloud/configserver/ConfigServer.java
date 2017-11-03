package com.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置中心服务端
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServer.class, args);
    }
}
