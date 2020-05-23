package com.imatia.pruebatecnica.config;

import com.imatia.pruebatecnica.model.entity.OrderState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Comparator;

@Configuration
@EnableSwagger2
public class AppConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("com.imatia.pruebatecnica.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Comparator<OrderState> OrderStateComparator (){
        return (o1, o2) -> o2.getStateUpdateDate().compareTo(o1.getStateUpdateDate());
    }
}
