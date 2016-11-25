package com.netcracker.sd4.client.configuration;

import com.netcracker.sd4.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfiguration {

    @Bean
    public Client client() {
        return new Client();
    }
}
