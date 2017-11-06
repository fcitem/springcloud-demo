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
    private String port;
	
	//测试远程拉取配置
	@Value("${foo}")
	private String foor;
	
	@RequestMapping("hello/{name}")
    public String sayHello(@PathVariable("name")String name,HttpServletRequest request) {
		request.getHeader("Connection");
		System.out.println(foor);
    	return "server "+port+" say hello："+name;
    }
}
