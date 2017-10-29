package com.springcloud.ribbon.feign;

import feign.Param;
import feign.RequestLine;

/**定制feign客户端，这种好像不能通过注入的方式提供服务
 * @author fengchao
 */
public interface CustomFeign {

	@RequestLine(value="GET /hello/{name}")
	public String sayHi(@Param("name")String name);
}
