package com.yuul.searching.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RequestConfig {


    /*
        Internal calls (S2S) to other NGOM services. In this case when no Eureka is available
        or in an environment where the Eureka is not available.
     */
    @Bean
    public RestTemplate restTemplateDefault() {
        return new RestTemplate();
    }
}
