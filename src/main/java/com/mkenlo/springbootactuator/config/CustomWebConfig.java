package com.mkenlo.springbootactuator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomWebConfig{

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN"))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
