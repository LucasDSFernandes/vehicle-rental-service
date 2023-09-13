package com.lucasdsf.api.vechiclerental.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.lucasdsf.api.vechiclerental.rest.controllers"))
          .paths(PathSelectors.any())
          .build()
          .pathMapping("/swagger-ui.html")
          .directModelSubstitute(LocalDate.class, String.class)
          .genericModelSubstitutes(ResponseEntity.class)
          .apiInfo(this.apiInfo());
    }	
    
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Aluguel de Carros")
				.description("Documentação da API de aluguel de carros.").version("1.0")
				.build();
	}
}
