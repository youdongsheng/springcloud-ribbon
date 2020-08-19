package com.bc.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getProviderPort")
    public String getProviderPort() {
        return restTemplate.getForObject("http://bc-provider/hello/getPort", String.class);
    }
}
