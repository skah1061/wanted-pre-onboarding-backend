package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentRequestDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wanted/recruitment")
public class RecruitmentController {
  private final RecruitmentService recruitmentService;

  @PostMapping
  public ResponseEntity<ApiResponseDto> createRecruitment(
      @RequestBody RecruitmentRequestDto requestDto){

    ApiResponseDto result = recruitmentService.createRecruitment(requestDto);


      return ResponseEntity.status(HttpStatus.CREATED).body(result);

  }
  @GetMapping
  public List<RecruitmentResponseDto> getRecruitments(){

    List<RecruitmentResponseDto> result = recruitmentService.getRecruitements();


    return result;
  }

}
