package com.heroku.demo.config;

import com.heroku.demo.web.LocalDateTimeConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    @Profile("postgres")
    @Primary
    @ConfigurationProperties(prefix = "custom.spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
}
