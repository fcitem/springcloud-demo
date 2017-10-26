package com.springcloud.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**测试controller
 * @author fengchao
 *
 */
@RestController
public class HelloController {

	@Value("${server.port}")
    String port;
	
	@RequestMapping(value="hello",method=RequestMethod.GET)
	@ResponseBody
    public String sayHello(HttpServletRequest request) {
    	return "hello fc：";
    }
}
