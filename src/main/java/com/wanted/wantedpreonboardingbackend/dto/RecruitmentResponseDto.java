package com.wanted.wantedpreonboardingbackend.dto;

import com.wanted.wantedpreonboardingbackend.employment.Recruitment;
import lombok.Getter;

@Getter
public class RecruitmentResponseDto {
  private Long id;
  private String companyName;
  private String country;
  private String area;

  private String position;
  private String compensation;
  private String skill;


  public RecruitmentResponseDto(Recruitment recruitment){
    this.id = recruitment.getId();
    this.companyName = recruitment.getCompany().getName();
    this.country = recruitment.getCompany().getCountry();
    this.area = recruitment.getCompany().getArea();

    this.position = recruitment.getPosition();
    this.compensation  = recruitment.getCompensation();
    this.skill = recruitment.getSkill();
  }
}
