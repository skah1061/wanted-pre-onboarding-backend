package com.wanted.wantedpreonboardingbackend.dto;

import com.wanted.wantedpreonboardingbackend.employment.Recruitment;
import java.util.List;
import lombok.Getter;

@Getter
public class RecruitmentDetailResponseDto {
  private Long id;
  private String companyName;
  private String country;
  private String area;

  private String position;
  private String compensation;
  private String skill;
  private String description;
  private List<RecruitmentResponseDto> recruitmentResponseDtoList;

  public RecruitmentDetailResponseDto(Recruitment recruitment, List<RecruitmentResponseDto> recruitmentResponseDtoList){
    this.id = recruitment.getId();
    this.companyName = recruitment.getCompany().getName();
    this.country = recruitment.getCompany().getCountry();
    this.area = recruitment.getCompany().getArea();

    this.position = recruitment.getPosition();
    this.compensation  = recruitment.getCompensation();
    this.skill = recruitment.getSkill();
    this.description = recruitment.getDescription();
    this.recruitmentResponseDtoList = recruitmentResponseDtoList;
  }
}
