package com.wanted.wantedpreonboardingbackend.dto;

import lombok.Getter;

@Getter
public class CompanyRequestDto {
  private Long id;
  private String position;
  private Integer compensation;
  private String skill;
  private String description;

}
