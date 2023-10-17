package com.wanted.wantedpreonboardingbackend.user;

import com.wanted.wantedpreonboardingbackend.employment.Recruitment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserRecruitment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(mappedBy = "user_recruitment")
  private User user;
  @OneToOne(mappedBy = "user_recruitment")
  private Recruitment recruitment;

}
