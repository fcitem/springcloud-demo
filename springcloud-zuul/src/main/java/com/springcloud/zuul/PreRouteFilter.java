package com.springcloud.zuul;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**路由之前过滤器1
 * @author fengchao
 *
 */
@Component
public class PreRouteFilter extends ZuulFilter {

	@Override
	public Object run() {
		// 过滤器的具体逻辑
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getParameter("token") != null) {
			ctx.setSendZuulResponse(true);// 对该请求进行路由
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true); // 设值，让下一个Filter看到上一个Filter的状态
		} else {
			ctx.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401); // 返回错误码
			ctx.setResponseBody("{\"result\":\"token is required!\"}");// 返回错误内容
			ctx.set("isSuccess", false);
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行该过滤器，此处为true，说明需要过滤
		return true;
	}

	@Override
	public int filterOrder() {
		// 通过int值来定义过滤器的执行顺序，数字越大，优先级越低
		return 0;
	}

	@Override
	public String filterType() {
		// 过滤器类型：pre/route/post/error;经过路由之前/之中/之后或者在error过滤器之后/请求发生错误;
		// 执行顺序为pre->route->post 或者 pre->route->error->post,post最后执行
		return "pre";
	}

}
