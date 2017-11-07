package com.springcloud.bus.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**事件监听处理类
 * @author fengchao
 *
 */
@Component
public class MyEventChangeListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent arg0) {
		System.out.println("收到自定义总线消息: "+arg0.getMessage());
	}

}
