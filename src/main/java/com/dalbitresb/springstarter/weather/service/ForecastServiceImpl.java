package com.dalbitresb.springstarter.weather.service;

import com.dalbitresb.springstarter.shared.exception.ResourceNotFoundException;
import com.dalbitresb.springstarter.shared.exception.ResourceValidationException;
import com.dalbitresb.springstarter.weather.domain.model.entity.Forecast;
import com.dalbitresb.springstarter.weather.domain.persistence.ForecastRepository;
import com.dalbitresb.springstarter.weather.domain.service.ForecastService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ForecastServiceImpl implements ForecastService {
  private static final String ENTITY = "Forecast";

  private final ForecastRepository repository;

  private final Validator validator;

  public ForecastServiceImpl(ForecastRepository repository, Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }

  @Override
  public List<Forecast> getAll() {
    return repository.findAll();
  }

  @Override
  public Forecast getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }

  @Override
  public Forecast create(Forecast request) {
    validateConstraints(request);

    return repository.save(request);
  }

  @Override
  public Forecast update(Long id, Forecast request) {
    validateConstraints(request);

    val entity = repository.findById(id);

    if (entity.isEmpty()) {
      throw new ResourceNotFoundException(ENTITY, id);
    }

    val updated = entity.get()
            .withDate(request.getDate())
            .withTemperatureC(request.getTemperatureC())
            .withSummary(request.getSummary());

    return repository.save(updated);
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    val entity = repository.findById(id);

    if (entity.isEmpty()) {
      throw new ResourceNotFoundException(ENTITY, id);
    }

    repository.delete(entity.get());
    return ResponseEntity.ok().build();
  }

  private <T> void validateConstraints(T request) {
    Set<ConstraintViolation<T>> violations = validator.validate(request);

    if (!violations.isEmpty()) {
      throw new ResourceValidationException(ENTITY, violations);
    }
  }
}
