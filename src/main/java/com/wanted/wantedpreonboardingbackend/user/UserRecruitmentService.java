package com.wanted.wantedpreonboardingbackend.user;

import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.employment.Recruitment;
import com.wanted.wantedpreonboardingbackend.employment.RecruitmentRepositoryImpl;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRecruitmentService {
  private final UserRepository userRepository;
  private final RecruitmentRepositoryImpl recruitmentRepository;
  private final UserRecruitmentRepository userRecruitmentRepository;

  public ApiResponseDto submit(Long companyId, Long userId) {

    Optional<User> user = userRepository.findById(userId);
    Optional<Recruitment> recruitment = recruitmentRepository.findById(companyId);
    if(user.isPresent()&&recruitment.isPresent()){
      UserRecruitment userRecruitment = new UserRecruitment(user.get(),recruitment.get());

      userRecruitmentRepository.save(userRecruitment);
    }
    else{
      return new ApiResponseDto("해당 회사 또는 유저가 존재하지 않습니다.",400);
    }
    return new ApiResponseDto("지원 완료",200);
  }
}
