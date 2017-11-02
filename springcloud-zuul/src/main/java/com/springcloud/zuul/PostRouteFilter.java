package com.springcloud.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**路由之后执行
 * @author fengchao
 *
 */
@Component
public class PostRouteFilter extends ZuulFilter {

	private Logger log=LoggerFactory.getLogger(PostRouteFilter.class);
	@Override
	public Object run() {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request= ctx.getRequest();
		log.info(request.getMethod() +" request "+ request.getRequestURL()+" is down" );
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
