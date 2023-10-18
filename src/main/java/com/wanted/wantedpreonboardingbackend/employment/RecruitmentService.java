package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.company.Company;
import com.wanted.wantedpreonboardingbackend.company.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentDetailResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentRequestDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentResponseDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

  private final CompanyRepository companyRepository;
  private final RecruitmentRepositoryImpl recruitmentRepository;

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

  public ApiResponseDto deleteRecruitment(Long id) {

    Optional<Recruitment> recruitment = recruitmentRepository.findById(id);
    if(recruitment.isPresent()){
      recruitmentRepository.delete(recruitment.get());
    }
    else{
      return new ApiResponseDto("해당 채용공고가 존재하지 않습니다.",400);
    }
    return new ApiResponseDto("채용공고 삭제 완료",200);
  }
  @Transactional
  public ApiResponseDto updateRecruitment(Long id , RecruitmentRequestDto requestDto){

    Optional<Recruitment> recruitment = recruitmentRepository.findById(id);
    if(recruitment.isPresent()){
      recruitment.get().update(requestDto);
    }
    else{
      return new ApiResponseDto("해당 채용공고가 존재하지 않습니다.",400);
    }
    return new ApiResponseDto("채용공고 수정 완료",200);
  }

  public RecruitmentDetailResponseDto getDetailRecruitements(Long id) {

    Optional<Recruitment> recruitment = recruitmentRepository.findById(id);
    if(recruitment.isPresent()) {

      List<RecruitmentResponseDto> recruitmentResponseDtoList = recruitmentRepository.findAllByCompany(recruitment.get().getCompany())
          .stream()
          .filter(e -> !e.getId().equals(id))
          .map(RecruitmentResponseDto::new)
          .toList();

      return new RecruitmentDetailResponseDto(recruitment.get(),recruitmentResponseDtoList);
    }
    else{
      throw new IllegalArgumentException("해당 기업을 찾을 수 없음");
    }
  }

  public List<RecruitmentResponseDto> searchRecruitments(String keyword) {

    return recruitmentRepository.searchKeywordRecruitment(keyword)
        .stream()
        .map(RecruitmentResponseDto::new)
        .toList();
  }
}
