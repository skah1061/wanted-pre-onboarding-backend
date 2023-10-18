package com.wanted.wantedpreonboardingbackend.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  protected String name;

  @Column(name = "country", nullable = false)
  protected String country;
  @Column(name = "area", nullable = false)
  protected String area;
}
