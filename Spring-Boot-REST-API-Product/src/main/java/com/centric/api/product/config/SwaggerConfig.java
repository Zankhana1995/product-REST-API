package com.centric.api.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * The configuration class for Swagger UI.
 *
 * @author Zankhana Patel
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket registrationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.centric.api.product.controller"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Product REST API")
                .description("Product REST API with Spring boot 2 and H2 database")
                .version("1.0.0")
                .contact(new Contact("Zankhana Patel", "", "zankhanapatel1995.zp@gmail.com"))
                .build();
    }

}
