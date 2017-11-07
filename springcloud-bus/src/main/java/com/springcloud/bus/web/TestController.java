package com.springcloud.bus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.bus.event.MyEvent;

@RestController
@RefreshScope
public class TestController {

	@Autowired
	ApplicationContext  context;
	@Value("${foo}")
	private String fooValue;
	
	/**测试分布式配置中心自动拉取配置
	 * @return
	 */
	@RequestMapping("test")
	public String bus(){
		return "config value foo:"+fooValue;
	}
	/**
	 * 测试自定义总线消息
	 */
	@RequestMapping("/test/custom")
	public void customBus(){
		MyEvent event=new MyEvent(this, context.getId(),"first message");
		context.publishEvent(event);
	}
}
