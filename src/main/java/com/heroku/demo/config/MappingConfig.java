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
        Resource jdk8Mappings = m_resourceLoader.getResource("classpath:/dozerJdk8Converters.xml");
        Resource customMappings = m_resourceLoader.getResource("classpath:/Dozer.xml");
        factory.setMappingFiles(new Resource[]{jdk8Mappings,  customMappings});
        return factory;
    }
}
