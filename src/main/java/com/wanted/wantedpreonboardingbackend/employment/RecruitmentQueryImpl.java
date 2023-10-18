package com.wanted.wantedpreonboardingbackend.employment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RecruitmentQueryImpl implements RecruitmentQuery{
  private final JPAQueryFactory jpaQueryFactory;
  private final QRecruitment qRecruitment = QRecruitment.recruitment;

  @Override
  public List<Recruitment> searchKeywordRecruitment(String keyword){

    return jpaQueryFactory.selectFrom(qRecruitment)
        .where(qRecruitment.company.name.like("%"+keyword+"%")
            .or(qRecruitment.company.area.like("%" + keyword + "%"))
            .or(qRecruitment.company.country.like("%" + keyword + "%"))
            .or(qRecruitment.position.like("%" + keyword + "%"))
            .or(qRecruitment.skill.like("%" + keyword + "%")))
        .fetch();

  }

}
