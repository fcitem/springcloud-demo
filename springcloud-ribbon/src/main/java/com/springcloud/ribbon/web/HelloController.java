package com.springcloud.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.ribbon.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService service;
	@RequestMapping("ribbon/{name}")
	public String test(@PathVariable("name") String name){
		return service.sayHello(name);
	}
}
