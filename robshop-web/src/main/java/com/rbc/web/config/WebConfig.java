package com.rbc.web.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.rbc.data.config","com.rbc.service.config","com.rbc.core.config","com.rbc.web"})
public class WebConfig {

}
