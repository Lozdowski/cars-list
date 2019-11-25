package carsawesome.docs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

// will run bean object- new Docket,
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket carsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("carsawesome.controller"))
                .paths(regex("/api/.*"))
                .build();
    }
}
