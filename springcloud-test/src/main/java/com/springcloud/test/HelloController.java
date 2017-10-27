package com.springcloud.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**测试controller
 * @author fengchao
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping(value="hello")
    public String sayHello(HttpServletRequest request) {
    	return "hello fc：";
    }
}
