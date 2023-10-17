package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.company.Company;
import com.wanted.wantedpreonboardingbackend.company.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentRequestDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentResponseDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

  private final CompanyRepository companyRepository;
  private final RecruitmentRepository recruitmentRepository;


  public ApiResponseDto createRecruitment(RecruitmentRequestDto requestDto){
  Optional<Company> company = companyRepository.findById(requestDto.getId());

  if(company.isPresent()) {
    Recruitment recruitment = new Recruitment(requestDto,company.get());

    recruitmentRepository.save(recruitment);
  }
  else{
    return new ApiResponseDto("해당 id가 없습니다.",400);
  }

    return new ApiResponseDto("채용공고 등록 성공", 201);
  }

  public List<RecruitmentResponseDto> getRecruitements() {



    return recruitmentRepository.findAll()
        .stream()
        .map(RecruitmentResponseDto::new)
        .toList();
  }
}
