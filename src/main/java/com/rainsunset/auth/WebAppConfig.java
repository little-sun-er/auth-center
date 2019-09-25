package com.rainsunset.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class WebAppConfig {

	@Value("${swagger.basePath}")
	private String swaggerBastPath;

	@Value("${swagger.title}")
	private String swaggerTitle;

	@Value("${swagger.description}")
	private String swaggerDesp;

	@Value("${swagger.contact}")
	private String swaggerCont;

	@Value("${swagger.version}")
	private String projVersion;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.securitySchemes(newArrayList(new ApiKey[] { this.apiKey() }))
				.select()
				.apis(RequestHandlerSelectors.basePackage(this.swaggerBastPath))
				.build()
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(this.swaggerTitle)
				.description(this.swaggerDesp)
				.termsOfServiceUrl("")
				.contact(this.swaggerCont)
				.version(this.projVersion)
				.build();
	}

	ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}
}
