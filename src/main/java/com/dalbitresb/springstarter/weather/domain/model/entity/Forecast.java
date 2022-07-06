package com.dalbitresb.springstarter.weather.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "forecasts")
public class Forecast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Date date;

  @Column(nullable = false)
  private int temperatureC;

  @Column()
  private String summary;
}
