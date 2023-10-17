package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.company.Company;
import com.wanted.wantedpreonboardingbackend.dto.CompanyRequestDto;
import com.wanted.wantedpreonboardingbackend.entity.TimeStamped;
import com.wanted.wantedpreonboardingbackend.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Getter
public class Recruitment extends TimeStamped {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(name = "position", nullable = false)
  protected String position;

  @Column(name = "compensation")
  protected Integer compensation;

  @Column(name = "skill")
  protected String skill;

  @Column(name = "description")
  protected String description;

  @ManyToOne
  @JoinColumn(name = "company_id")
  protected Company company;


  public Recruitment(CompanyRequestDto requestDto, Company company){
    this.position = requestDto.getPosition();
    this.compensation = requestDto.getCompensation();
    this.skill = requestDto.getSkill();
    this.description = requestDto.getDescription();
  }
}
