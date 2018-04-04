package com.springcloud.ribbon.restTemplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

import rx.Observable;
import rx.Subscriber;
import rx.internal.util.ObserverSubscriber;

/**ribbon负载均衡
 * 通过restTemplete的方式调用
 * @author fengchao
 *
 */
@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	private LoadBalancerClient loadBalancerClient;

	private String SERVICE_NAME = "SERVICE-HI";

	/*@HystrixCommand(fallbackMethod = "hasError")
	public String sayHello(String name) {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose(SERVICE_NAME);
//		String response = restTemplate.getForObject("http://" + SERVICE_NAME + "/hello", String.class);
		ResponseEntity<String> response=restTemplate.getForEntity("http://" + SERVICE_NAME + "/hello", String.class);
		return response.getBody() + "服务端口:" + serviceInstance.getPort();
	}*/

	@HystrixCommand(fallbackMethod = "hasError")
	public AsyncResult<String> sayHello(final String name) {
		/*ServiceInstance serviceInstance = this.loadBalancerClient.choose(SERVICE_NAME);*/
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON + ";charset=UTF-8"));
		//设置短连接
		/*headers.set("Connection", "close");*/
		
		//目前resttemplete长连接的方式会造成eof异常 ?
		/*headers.set("Connection", "keep-alive");*/

		/*headers.set("Accept-Encoding", "GZIP");*/
		/*headers.set("Transfer-Encoding","chunked");*/
        return new AsyncResult<String>() {
			@Override
			public String invoke() {
				HttpEntity<String> entity = new HttpEntity<String>(null, headers);
				ResponseEntity<String> response=restTemplate.exchange("http://" + SERVICE_NAME + "/hello/{name}",HttpMethod.GET,entity,String.class,name);
				return response.getBody() + "服务端口:";
			}
		};
		/*HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response=restTemplate.exchange("http://" + SERVICE_NAME + "/hello/{name}",HttpMethod.GET,entity,String.class,name);
		return response.getBody() + "服务端口:";*/
	}
	/**服务故障回调方法
	 * @param name
	 * @return
	 */
	public String hasError(String name) {
		return "service has error at port";
	}
}
