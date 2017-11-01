package com.springcloud.zuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**为路由提供Hystrix回退，当Zuul中给定路由的电路跳闸时，您可以通过创建类型为ZuulFallbackProvider的bean来提供回退响应
 * @author fengchao
 *
 */
@Component
public class MyFallbackProvider implements ZuulFallbackProvider {
    /* 
     * return 可以回退的服务ID
    */
    @Override
    public String getRoute() {
    	//可回退的ServiceID，如果希望为所有路由提供默认的回退，这儿可返回 * 或者 NULL
        return "service-hi";
    }

    //有错误提供返回的ClientHttpResponse作为后备
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 500;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ERROR";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("server error occur".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
