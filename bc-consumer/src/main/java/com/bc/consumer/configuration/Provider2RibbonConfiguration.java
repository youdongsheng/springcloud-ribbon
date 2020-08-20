package com.bc.consumer.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "bc-provider2", configuration = Provider2RibbonConfiguration.RibbonClientConfiguration.class)
public class Provider2RibbonConfiguration {


    @Configuration
    protected static class RibbonClientConfiguration {
        @Bean
        public IRule ribbonRule() {
            return new RandomRule();
        }
    }
}
