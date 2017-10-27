package com.springcloud.ribbon.feign;

import feign.RequestLine;

/**定制feign客户端不能通过注入的方式
 * @author fengchao
 */
public interface CustomFeign {

	@RequestLine(value="GET /hello")
	public String sayHi();
}
