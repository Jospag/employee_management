package com.semicolon.springbootbackend.config;

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
 * Configuration for Swagger API documentation.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configures the Swagger documentation for the API.
     *
     * @return Docket instance for Swagger configuration
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.semicolon.springbootbackend.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Provides API information for Swagger documentation.
     *
     * @return ApiInfo instance with API details
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Employee Management System API")
                .description("REST API for managing employee data")
                .version("1.0.0")
                .contact(new Contact("Jospag", "https://github.com/jospag", ""))
                .build();
    }
}
