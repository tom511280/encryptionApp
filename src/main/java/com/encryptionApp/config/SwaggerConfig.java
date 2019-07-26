package com.encryptionApp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "spring.swagger.enabled", matchIfMissing = true)
public class SwaggerConfig {
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.encryptionApp.controller"))
				.paths(PathSelectors.any()).build();

	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				   .title("實作各式加解密的API")
				   .description("這是一個說明Api文檔的介面，提供各個Api的相關資訊！")
				   .termsOfServiceUrl("")
				   .description("")
				   .contact("")
				   .version("v1").build();
		
	}
}
