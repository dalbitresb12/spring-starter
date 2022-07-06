package com.dalbitresb.springstarter.weather.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ForecastRequest {
  @NotNull
  @NotBlank
  private Date date;

  @NotNull
  @NotBlank
  private int temperatureC;

  @NotNull
  @NotBlank
  private String summary;
}
