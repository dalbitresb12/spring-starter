package com.dalbitresb.springstarter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class SpringStarterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringStarterApplication.class, args);
  }

}
