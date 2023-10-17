package com.wanted.wantedpreonboardingbackend.employment;

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

@Entity
@Getter
public class Employment extends TimeStamped {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(name = "title", nullable = false)
  protected String title;

  @Column(name = "country", nullable = false)
  protected String country;

  @Column(name = "position", nullable = false)
  protected String position;

  @Column(name = "compensation")
  protected Integer compensation;

  @Column(name = "skill")
  protected String skill;

  @Column(name = "description")
  protected String description;

  @ManyToOne
  @JoinColumn(name = "user_id")
  protected User user;

//  "채용공고_id": 채용공고_id,
//      "회사명":"원티드랩",
//      "국가":"한국",
//      "지역":"서울",
//      "채용포지션":"백엔드 주니어 개발자",
//      "채용보상금":1500000,
//      "사용기술":"Python",
//      "채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
//      "회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List (선택사항 및 가산점요소).
}
