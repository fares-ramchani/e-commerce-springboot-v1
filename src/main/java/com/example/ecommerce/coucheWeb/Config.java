package com.example.ecommerce.coucheWeb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class Config {
    @Bean
    CorsConfigurationSource CorsConfigurationSource()
    {
        CorsConfiguration CorsConfiguration=new CorsConfiguration();
        CorsConfiguration.addAllowedOrigin("*");
        CorsConfiguration.addAllowedHeader("*");
        CorsConfiguration.addAllowedMethod("*");
        CorsConfiguration.addExposedHeader("*");
        UrlBasedCorsConfigurationSource Source=new UrlBasedCorsConfigurationSource();
        Source.registerCorsConfiguration("/**",CorsConfiguration);
        return Source;
    }
}
