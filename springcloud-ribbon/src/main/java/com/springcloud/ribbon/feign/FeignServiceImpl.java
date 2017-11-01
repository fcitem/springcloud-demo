package com.springcloud.ribbon.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

	@Override
	public String sayHello(String name) {
		return "server has error";
	}

}
