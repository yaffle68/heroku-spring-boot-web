package com.heroku.demo.config;

import com.heroku.demo.web.LocalDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by simon.harding on 22.03.2017.
 */
@Configuration
public class WebConfig {

    @Bean
    LocalDateTimeConverter localDateTimeConverter() {
        return new LocalDateTimeConverter();
    }
}
