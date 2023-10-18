package com.wanted.wantedpreonboardingbackend.employment;

import java.util.List;

public interface RecruitmentQuery{
  List<Recruitment> searchKeywordRecruitment(String keyword);
}
