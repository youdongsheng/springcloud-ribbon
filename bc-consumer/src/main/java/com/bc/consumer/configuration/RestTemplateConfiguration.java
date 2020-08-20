package com.bc.consumer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory){
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(3000);
        clientHttpRequestFactory.setConnectTimeout(3000);
        return clientHttpRequestFactory;
    }

}
