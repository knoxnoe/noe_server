package com.noe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 设置属性
        // 设置跨域请求地址
        corsConfiguration.addAllowedOrigin("*");
        // 配置跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        // 配置跨域的请求方法
        corsConfiguration.addAllowedMethod("*");
        // 表示跨域的时候请求的是否使用同一个session
        corsConfiguration.setAllowCredentials(true);

        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 必须/**
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
