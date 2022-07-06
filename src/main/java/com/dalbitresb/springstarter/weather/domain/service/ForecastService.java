package com.dalbitresb.springstarter.weather.domain.service;

import com.dalbitresb.springstarter.weather.domain.model.entity.Forecast;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ForecastService {
  List<Forecast> getAll();
  Forecast getById(Long id);
  Forecast create(Forecast request);
  Forecast update(Long id, Forecast request);
  ResponseEntity<?> delete(Long id);
}
