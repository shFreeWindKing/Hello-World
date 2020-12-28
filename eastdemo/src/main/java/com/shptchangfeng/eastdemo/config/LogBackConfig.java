package com.shptchangfeng.eastdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogBackConfig {
    private static final Logger Log = LoggerFactory.getLogger(LogBackConfig.class);
    @Bean
    public void logMethod() {
        Log.info("===============print log===============");
        Log.warn("=============test logback debug=============");
    }
}
