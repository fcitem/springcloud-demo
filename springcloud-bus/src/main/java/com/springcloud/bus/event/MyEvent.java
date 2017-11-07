package com.springcloud.bus.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**自定义总线事件
 * @author fengchao
 *
 */
public class MyEvent extends RemoteApplicationEvent{

	private static final long serialVersionUID = 1L;
	private String message;
	@Override
	public String getOriginService() {
		System.out.println(super.getOriginService());
		return super.getOriginService();
	}
	@Override
	public String getDestinationService() {

		System.out.println(super.getDestinationService());
		return super.getDestinationService();
	}
	@Override
	public String getId() {
		System.out.println(super.getId());
		return super.getId();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyEvent(Object source, String originService,String msg) {
		super(source,originService);
		this.message=msg;
	}
	//jackson序列化反序列化必须有无参构造函数
	public MyEvent(){
		
	}
	
}
