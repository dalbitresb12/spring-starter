package com.dalbitresb.springstarter.weather.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ForecastResource {
  private Long id;
  private Date date;
  private int temperatureC;
  private String summary;
}
