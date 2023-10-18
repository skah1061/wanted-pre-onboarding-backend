package com.wanted.wantedpreonboardingbackend.company;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class CompanyResponseDto {

  private Long id;

  protected String name;

  protected String country;

  protected String area;

  public CompanyResponseDto(Company company){
    this.id = company.getId();
    this.name = company.getName();
    this.country = company.getCountry();
    this.area = company.getArea();
  }
}
