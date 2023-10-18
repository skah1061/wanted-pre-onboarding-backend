package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.company.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepositoryImpl extends JpaRepository<Recruitment,Long>,
    RecruitmentQuery {

  List<Recruitment> findAllByCompany(Company company);
}
