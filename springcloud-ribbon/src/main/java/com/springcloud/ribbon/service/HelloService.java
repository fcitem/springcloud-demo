package com.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**ribbon负载均衡
 * @author fengchao
 *
 */
@Service
public class HelloService {

	@Value("${server.port}")
	private String port;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	private String SERVICE_NAME = "SERVICE-HI";

	@HystrixCommand(fallbackMethod = "hasError")
	public String sayHello(String name) {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose(SERVICE_NAME);
		String response = restTemplate.getForObject("http://" + SERVICE_NAME + "/hello", String.class);
		return response + "服务端口:" + serviceInstance.getPort();
	}

	/**服务故障回调方法
	 * @param name
	 * @return
	 */
	public String hasError(String name) {
		return "service has error at port";
	}
}
