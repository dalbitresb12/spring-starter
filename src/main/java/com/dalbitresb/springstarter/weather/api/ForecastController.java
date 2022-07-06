package com.dalbitresb.springstarter.weather.api;

import com.dalbitresb.springstarter.weather.domain.service.ForecastService;
import com.dalbitresb.springstarter.weather.mapping.ForecastMapper;
import com.dalbitresb.springstarter.weather.resource.ForecastRequest;
import com.dalbitresb.springstarter.weather.resource.ForecastResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Forecasts")
@RestController
@RequestMapping("api/v1/forecasts")
public class ForecastController {
  private final ForecastService service;

  private final ForecastMapper mapper;

  public ForecastController(ForecastService service, ForecastMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public List<ForecastResource> getAll() {
    val entities = service.getAll();
    return mapper.toResourceList(entities);
  }

  @GetMapping("{id}")
  public ForecastResource getById(@PathVariable Long id) {
    val entity = service.getById(id);
    return mapper.toResource(entity);
  }

  @PostMapping
  public ForecastResource create(@RequestBody ForecastRequest request) {
    val mapped = mapper.toModel(request);
    val entity = service.create(mapped);
    return mapper.toResource(entity);
  }

  @PutMapping("{id}")
  public ForecastResource update(@PathVariable Long id, @RequestBody ForecastRequest request) {
    val mapped = mapper.toModel(request);
    val entity = service.update(id, mapped);
    return mapper.toResource(entity);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    return service.delete(id);
  }
}
