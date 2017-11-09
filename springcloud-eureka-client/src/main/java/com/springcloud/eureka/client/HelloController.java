package com.springcloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**测试controller，@api用在类上，说明该类的作用
 * @author fengchao
 *
 */
@RestController
@Api("服务提供者")
public class HelloController {

	@Value("${server.port}")
    String port;
	
	/**@ApiImplicitParam作用在方法上，对参数做描述
	 * @ApiResponses响应状态以及描述
	 * @param name
	 * @return
	 */
	@ApiOperation(value="服务端hello响应",notes="尽量传入name参数")
	//paramType 有五个可选值 ： path, query, body, header, form,根据实际运用解决
	@ApiImplicitParam(name = "name", value = "你需要问候的名字", required = true, dataType = "String",paramType="path")
	@ApiResponses(@ApiResponse(code=200,message="响应成功"))
	@RequestMapping(value="hello/{name}",method=RequestMethod.GET)
    public String sayHello(@ApiParam @PathVariable("name") String name) {
    	return "server "+port+" say hello:"+name;
    }
	
}
