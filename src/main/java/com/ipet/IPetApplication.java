package com.ipet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.ipet.mapper")
public class IPetApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(IPetApplication.class, args);
    }
}
