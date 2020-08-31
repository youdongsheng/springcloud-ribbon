package com.bc.consumer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@Configuration
public class RestTemplateConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory){
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            System.out.println(LocalTime.now()+ "---" + new String(body, "UTF-8"));
            return execution.execute(request,body);
        }));
        return restTemplate;
    }

    /**
     * apache httpclient
     * @return
     */
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(1000);
        clientHttpRequestFactory.setConnectTimeout(1000);
        return clientHttpRequestFactory;
    }
//
//    /**
//     * okhttp3
//     * @return
//     */
//    @Bean
//    public ClientHttpRequestFactory okHttp3ClientHttpRequestFactory(){
//        OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();
//        okHttp3ClientHttpRequestFactory.setReadTimeout(3000);
//        okHttp3ClientHttpRequestFactory.setConnectTimeout(3000);
//        okHttp3ClientHttpRequestFactory.setWriteTimeout(3000);
//        return okHttp3ClientHttpRequestFactory;
//    }
//
//    /**
//     * jdk httpUrlConnection
//     * @return
//     */
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
//        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//        simpleClientHttpRequestFactory.setReadTimeout(3000);
//        simpleClientHttpRequestFactory.setConnectTimeout(3000);
//        return simpleClientHttpRequestFactory;
//
//    }



}
