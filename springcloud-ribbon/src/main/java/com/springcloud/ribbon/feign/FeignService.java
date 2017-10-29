package com.springcloud.ribbon.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**feign客户端
 * 注解@FeignClient（“服务名”），来指定调用哪个服务。可通过@autowired方式注入
 * @author fengchao
 *
 */
@FeignClient(name="SERVICE-HI",configuration=FeignConfigure.class)
public interface FeignService {

	/*@RequestMapping(value="hello",method=RequestMethod.GET)*/
	@GetMapping("hello/{name}")
	public String sayHello(@PathVariable("name") String name);
}
