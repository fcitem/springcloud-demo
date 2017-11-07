package com.springcloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

/**测试消息推送更新
 * @author fengchao
 *配置变更后只需要 POST请求到 /bus/refresh?destation=ApplicationContextID(参数有代表指定服务)即可通知客户端更新
 *默认情况下ApplicationContext ID是spring.application.name:server.port
 */
@SpringBootApplication
//自定义总线事件注册扫描
@RemoteApplicationEventScan(basePackages="com.springcloud.bus.event")
public class BusClient {

	public static void main(String[] args) {
		SpringApplication.run(BusClient.class, args);
	}
}
