package com.ipet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Administrator
 * @Func swagger配置
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
 
	private final String basePackage= "com.ipet"; 
	
	@Bean
	public Docket createRestCusApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("cus")
				.apiInfo(createCusApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(this.basePackage))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * Create Client API infomation
	 * 
	 * @return
	 */
	private ApiInfo createCusApiInfo() {
		return new ApiInfoBuilder()
        .title("活动分享系统服务")
        .description("")
        .license("")
        .licenseUrl("")
        .termsOfServiceUrl("")
        .version("1.0.0")
        .contact(new Contact("S0105","", "cenkun@chinalife.com.hk"))
        .build();
	}
}
