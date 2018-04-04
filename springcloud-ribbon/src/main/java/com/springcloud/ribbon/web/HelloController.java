package com.springcloud.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.springcloud.ribbon.feign.AddHeaderInterceptor;
import com.springcloud.ribbon.feign.CustomFeign;
import com.springcloud.ribbon.feign.FeignService;
import com.springcloud.ribbon.restTemplete.HelloService;

import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;

//定制ferign客户端需导入FeignClientsConfiguration
@Import(FeignClientsConfiguration.class)
@RestController
public class HelloController {

	@Autowired
	HelloService service;
	
	/**
	 * 注入Feigrn客户端
	 */
	@Autowired
	FeignService feignService;
	
	//定制feign导入
	private CustomFeign customFeign;
	
	/**
	 * @param decoder 由imprt的decoder导入
	 * @param encoder 由imprt的encoder导入
	 * @param client 由imprt的FeignClientsConfiguration导入
	 */
	public HelloController(Decoder decoder, Encoder encoder, Client client) {
		this.customFeign = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .requestInterceptor(new AddHeaderInterceptor())
                .target(CustomFeign.class,"http://SERVICE-HI");
	}
	
	/**通过restTemplete的方式调用服务
	 * @param name
	 * @return
	 */
	@RequestMapping("ribbon/{name}")
	public String test(@PathVariable("name") String name){
		AsyncResult<String> result= service.sayHello(name);
		return result.get();
	}
	/**通过feign可注入的方式调用服务
	 * @return
	 */
	@RequestMapping("ribbon/feign/{name}")
	public String testFign(@PathVariable("name") String name){
		return feignService.sayHello(name);
	}
	/**通过自定义feign方式调用
	 * @return
	 */
	@RequestMapping("ribbon/feign/customer/{name}")
	public String testCustomerFign(@PathVariable("name") String name){
		return customFeign.sayHi(name);
	}
}
