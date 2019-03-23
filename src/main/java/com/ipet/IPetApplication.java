package com.ipet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@SpringBootApplication
@MapperScan(basePackages = "com.ipet.mapper")
public class IPetApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(IPetApplication.class, args);
    }
}
