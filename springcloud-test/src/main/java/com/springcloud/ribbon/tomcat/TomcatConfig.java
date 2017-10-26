package com.springcloud.ribbon.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * tomcat 配置
 * 这儿没启用
 * @author liaokailin
 * @version $Id: TomcatConfig.java, v 0.1 2015年10月4日 上午12:11:47 liaokailin Exp $
 */
@Configuration
public class TomcatConfig {


	    @Bean
	    public EmbeddedServletContainerFactory servletContainer() {
	        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	        tomcat.setPort(8010);
	        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
	        protocol.setMaxHttpHeaderSize(18192);
	        connector.setPort(8445);
	        tomcat.addAdditionalTomcatConnectors(connector);
	        return tomcat;
	    }
}
