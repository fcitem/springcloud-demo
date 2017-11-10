package com.springcloud.ribbon.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**feign客户端
 * 注解@FeignClient（“服务名”），来指定调用哪个服务。可通过@autowired方式注入
 * @author fengchao
 *
 */
@FeignClient(name="SERVICE-HI",configuration=FeignConfigure.class,fallback=FeignServiceImpl.class)
public interface FeignService {

	/*@RequestMapping(value="hello",method=RequestMethod.GET)*/
	@GetMapping("hello/{name}")
	//如果在参数前面没有加@PathVariable注解，默认feign会将参数按@requestBody注解处理，并且默认接受Post请求
	public String sayHello(@PathVariable("name") String name);
}
