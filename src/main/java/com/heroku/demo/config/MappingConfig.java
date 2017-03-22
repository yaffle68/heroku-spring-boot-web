package com.heroku.demo.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by simon.harding on 09.03.2017.
 */
@Configuration
public class MappingConfig {

    @Autowired
    private ResourceLoader m_resourceLoader;

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapper() {
        DozerBeanMapperFactoryBean factory = new DozerBeanMapperFactoryBean();
        Resource resource = m_resourceLoader.getResource("classpath:/dozerJdk8Converters.xml");
        factory.setMappingFiles(new Resource[]{resource});
        return factory;
    }
}
