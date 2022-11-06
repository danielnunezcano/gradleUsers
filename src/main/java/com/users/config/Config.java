package com.users.config;

import com.users.domain.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.users.infrastructure.repository")
@ComponentScan("com.users.aspects")
public class Config {

    @Value("${validation.height.less}")
    private Double heightLess;

    @Value("${validation.height.over}")
    private Double heightOver;

    @Value("${validation.weight.less}")
    private Double weightLess;

    @Value("${validation.weight.over}")
    private Double weightOver;

    @Value("${validation.name.regex}")
    private String nameRegex;

    @Bean
    public Constants constants() {
        return new Constants(heightLess, heightOver, weightLess, weightOver, nameRegex);
    }


}