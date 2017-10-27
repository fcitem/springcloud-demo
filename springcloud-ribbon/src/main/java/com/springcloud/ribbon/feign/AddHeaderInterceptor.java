package com.springcloud.ribbon.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**拦截增加Header属性
 * 由于Connection在长连接环境下,服务提供端报EOF异常。我也不知道why
 * @author fengchao
 *
 */
public class AddHeaderInterceptor implements RequestInterceptor{

	@Override
	public void apply(RequestTemplate template) {
		//由于Connection在长连接环境下,服务提供端会报EOF异常?
		template.header("Connection", "close");
	}

}
