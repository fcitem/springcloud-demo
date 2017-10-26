package com.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RibbonClient {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClient.class, args);
	}
	
	/**@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	 * 加了loadBalanced注解才会通过eureka的注册服务调用服务
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate(){
		RestTemplate restTemplate= new RestTemplate();
		return restTemplate;
	}
	/**负载均衡策略
	 * @return
	 */
	/*@Bean
	IRule ribbonRule(){
		//轮询策略
		RoundRobinRule rule=new RoundRobinRule();
		return rule;
	}*/
}
