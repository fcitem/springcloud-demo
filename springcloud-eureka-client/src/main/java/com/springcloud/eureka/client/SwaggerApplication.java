package com.springcloud.eureka.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**@EnableSwagger2注解来启用Swagger2
 * @author fengchao
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerApplication {

	/**创建docket并注入容器
	 * @return
	 */
	@Bean
	public Docket createDocket(){
		//select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，在指定包扫描路径下除了被@ApiIgnore指定的请求
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.springcloud.eureka.client"))
				.paths(PathSelectors.any()).build();
	}
	/**api描述信息
	 * 这些基本信息会展现在文档页面中
	 * @return
	 */
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").description("基于Springcloud").termsOfServiceUrl("")
				.contact(new Contact("fc","http://github.com/fcitem","hellokitty@dd.com")).version("1.0").build();
	}
}
