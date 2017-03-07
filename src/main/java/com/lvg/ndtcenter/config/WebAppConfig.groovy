package com.lvg.ndtcenter.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
class WebAppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext context

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext
    }
}
