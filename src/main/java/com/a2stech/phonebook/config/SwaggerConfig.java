package com.a2stech.phonebook.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

	
	/*@Bean
	public Docket apiDocGen() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.a2stech.phonebook"))
				.paths(PathSelectors.any())
				.build();
	}
	*/
	
	/*
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.a2stech.phonebook"))
				.paths(PathSelectors.any())
				.build();
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("A2S Technologies API")
				.description("This API only for Client App Development")
				.termsOfServiceUrl("https://www.google.com")
				//.contact("skaleeminfo@gmail.com")
				.license("A2S Technologies")
				.licenseUrl("skaleeminfo@gmail.com")
				.version("1.0")
				.build();
	}*/
}