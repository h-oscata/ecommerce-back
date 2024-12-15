package com.umarket.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Redirige las solicitudes a /api/products/** al Product Service
                .route("product-service", r -> r
                        .path("/api/products/**")
                        .uri("http://localhost:8081")  // Dirección del Product Service
                )
                // Nueva ruta para redirigir las solicitudes a /api/users/** al User Service
                .route("user-service", r -> r
                        .path("/api/users/**")  // Redirige todas las peticiones que coincidan con este path
                        .uri("http://localhost:8082")  // Dirección del User Service
                )
                .build();
    }
}