package com.rbc.data.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.rbc.data.model","com.rbc.data.dao"})
@EntityScan(basePackages = { "com.rbc.data.model" })
@EnableJpaRepositories(basePackages = "com.rbc.data.dao")
@EnableTransactionManagement
public class DataConfig {

}
