package com.dalbitresb.springstarter.weather.domain.persistence;

import com.dalbitresb.springstarter.weather.domain.model.entity.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {}
