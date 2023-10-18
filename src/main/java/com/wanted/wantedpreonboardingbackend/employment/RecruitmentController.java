package com.wanted.wantedpreonboardingbackend.employment;

import com.wanted.wantedpreonboardingbackend.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentRequestDto;
import com.wanted.wantedpreonboardingbackend.dto.RecruitmentResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  @GetMapping("/{id}")
  public RecruitmentResponseDto getDetailRecruitments(@PathVariable Long id){

    RecruitmentResponseDto result = recruitmentService.getDetailRecruitements(id);


    return result;
  }
  @GetMapping
  public List<RecruitmentResponseDto> getRecruitments(){

    List<RecruitmentResponseDto> result = recruitmentService.getRecruitements();


    return result;
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponseDto> deleteRecruitment(@PathVariable Long id){
    ApiResponseDto result = recruitmentService.deleteRecruitment(id);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  @PutMapping("/{id}")
  public ResponseEntity<ApiResponseDto> updateRecruitment(
      @PathVariable Long id,
      @RequestBody RecruitmentRequestDto requestDto){
    ApiResponseDto result = recruitmentService.updateRecruitment(id,requestDto);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }


}
