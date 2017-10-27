package com.springcloud.eureka.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**测试controller
 * @author fengchao
 *
 */
@RestController
public class HelloController {

	/*@Value("${server.port}")
    String port;*/
	@RequestMapping("hello")
    public String sayHello(HttpServletRequest request) {
		System.out.println(request.getHeader("Connection"));
    	return "hello fc：";
    }
}
