package com.springcloud.eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**测试controller
 * @author fengchao
 *
 */
@RestController
public class HelloController {

	@RequestMapping("hello")
    public String sayHello() {
    	return "hello fc";
    }
}
