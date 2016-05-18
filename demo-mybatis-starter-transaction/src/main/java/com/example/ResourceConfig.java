package com.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ResourceConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    final Logger logger = LogManager.getLogger(getClass());

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 리소스 폴더 추가
        String handler = "/images/**";
        String resourceLocations = "file:///c:/UpFile/images/";

        registry.addResourceHandler(handler).addResourceLocations(resourceLocations);
        logger.error("handler: " + handler + " location: " + resourceLocations);

        super.addResourceHandlers(registry);
    }
}
