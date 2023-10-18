package com.wanted.wantedpreonboardingbackend.user;

import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/wanted/user_recruitment")
public class UserRecruitmentController {
  private final UserRecruitmentService userRecruitmentService;
  @PostMapping
  public ResponseEntity<ApiResponseDto> createRecruitment(
      @RequestParam("company_id") Long company_id, @RequestParam("user_id") Long user_id){

    ApiResponseDto result = userRecruitmentService.submit(company_id,user_id);


    return ResponseEntity.status(HttpStatus.OK).body(result);

  }
}
