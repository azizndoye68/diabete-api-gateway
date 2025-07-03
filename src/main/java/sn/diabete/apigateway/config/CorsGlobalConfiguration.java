package sn.diabete.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsGlobalConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://localhost:3000"); // Autoriser ton frontend React
        corsConfig.addAllowedHeader("*"); // Autoriser tous les headers
        corsConfig.addAllowedMethod("*"); // Autoriser toutes les méthodes HTTP
        corsConfig.setAllowCredentials(true); // Si tu as besoin de cookies ou tokens

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Appliquer sur toutes les routes

        return new CorsWebFilter(source);
    }
}

