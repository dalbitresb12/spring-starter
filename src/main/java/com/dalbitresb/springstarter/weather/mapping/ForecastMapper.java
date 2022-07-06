package com.dalbitresb.springstarter.weather.mapping;

import com.dalbitresb.springstarter.shared.mapping.EnhancedModelMapper;
import com.dalbitresb.springstarter.weather.domain.model.entity.Forecast;
import com.dalbitresb.springstarter.weather.resource.ForecastRequest;
import com.dalbitresb.springstarter.weather.resource.ForecastResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ForecastMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public ForecastResource toResource(Forecast model) {
    return mapper.map(model, ForecastResource.class);
  }

  public List<ForecastResource> toResourceList(List<Forecast> models) {
    return mapper.mapList(models, ForecastResource.class);
  }

  public Forecast toModel(ForecastRequest request) {
    return mapper.map(request, Forecast.class);
  }
}
