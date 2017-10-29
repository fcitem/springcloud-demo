package com.springcloud.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**测试controller
 * @author fengchao
 *
 */
@RestController
public class HelloController {
	
	@Value("${server.port}")
    String port;
	
	@RequestMapping("hello/{name}")
    public String sayHello(@PathVariable("name")String name,HttpServletRequest request) {
		request.getHeader("Connection");
    	return "server "+port+" say hello："+name;
    }
}
