package com.wanted.wantedpreonboardingbackend.company;

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
