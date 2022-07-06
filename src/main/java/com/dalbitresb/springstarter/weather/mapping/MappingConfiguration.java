package com.dalbitresb.springstarter.weather.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("forecastMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public ForecastMapper forecastMapper() {
    return new ForecastMapper();
  }
}
