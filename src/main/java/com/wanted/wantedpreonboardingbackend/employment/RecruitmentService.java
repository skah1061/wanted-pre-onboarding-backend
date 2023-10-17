package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.company.Company;
import com.wanted.wantedpreonboardingbackend.company.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.CompanyRequestDto;
import com.wanted.wantedpreonboardingbackend.user.User;
import com.wanted.wantedpreonboardingbackend.user.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

  private final CompanyRepository companyRepository;
  private final RecruitmentRepository recruitmentRepository;


  public ApiResponseDto createRecruitment(CompanyRequestDto requestDto){
  Optional<Company> company = companyRepository.findById(requestDto.getId());

  if(company.isPresent()) {
    Recruitment recruitment = new Recruitment(requestDto,company.get());

    recruitmentRepository.save(recruitment);
  }
  else{
    throw new IllegalArgumentException("해당 id의 회사가 없습니다.");
  }

    return new ApiResponseDto("채용공고 등록 성공", 201);
  }
}
