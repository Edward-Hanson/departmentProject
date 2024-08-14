package com.hanson.department_service.config;

import com.hanson.department_service.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient() {
       HttpServiceProxyFactory httpServiceProxyFactory =
               HttpServiceProxyFactory.builder()
                       .exchangeAdapter(WebClientAdapter.create(employeeWebClient()))
                       .build();
       return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}
