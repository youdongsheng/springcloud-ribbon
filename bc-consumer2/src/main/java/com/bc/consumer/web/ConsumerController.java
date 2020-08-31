package com.bc.consumer.web;

import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/getProviderPort2/{name}")
    public String getProviderPort2(@PathVariable String name) {
        return restTemplate.getForObject("http://bc-provider2/hello/getPort",String.class,name);
    }
}
