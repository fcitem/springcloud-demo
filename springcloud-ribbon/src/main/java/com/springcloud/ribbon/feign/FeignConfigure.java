package com.springcloud.ribbon.feign;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

/**扩展feign配置以支持短连接
 * 此处不要加任何@configure，若一定要加则将此类位置移到包扫描路径外
 * {@link https://github.com/OpenFeign/feign}
 * @author fengchao
 *
 */
public class FeignConfigure {

	@Bean 
	public RequestInterceptor requestInterceptor(){
		return new AddHeaderInterceptor();
	}
}
