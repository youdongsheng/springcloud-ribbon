package com.bc.consumer;

import com.bc.consumer.ribbon.DefaultRibbonClientConfiguration;
import com.bc.consumer.ribbon.Provider2RibbonClientConfiguration;
import com.bc.consumer.ribbon.ProviderRibbonClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@RibbonClients(value = {@RibbonClient(value = "bc-provider", configuration = ProviderRibbonClientConfiguration.class),
        @RibbonClient(value = "bc-provider2", configuration = Provider2RibbonClientConfiguration.class)
}, defaultConfiguration = DefaultRibbonClientConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.bc.consumer.ribbon.*"})})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
