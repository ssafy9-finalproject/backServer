package com.ssafy.edu.review.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.review.model.dao.ReviewMapper;
import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseEntity;
import com.ssafy.edu.review.model.dto.ReviewDate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

	private final ReviewMapper reviewMapper;

	@Transactional(readOnly = true)
	@Override
	public List<MyPlanResponseDto> planList(String id) {
		return reviewMapper.planList(id);
	}
	@Transactional(readOnly = true)
	@Override
	public MyPlanReviewResponseDto myPlanReview(String pid) {
		List<MyPlanReviewResponseEntity> rList = reviewMapper.myPlanReview(pid);
		MyPlanReviewResponseDto dto = new MyPlanReviewResponseDto(
				rList.get(0).getPlan_id(), 
				rList.get(0).getMember_id(), rList.get(0).getTitle(), 
				rList.get(0).getStart_date(), rList.get(0).getEnd_date(), rList.get(0).getContents());
		
		
		long daysDifference = ChronoUnit.DAYS.between(rList.get(0).getStart_date(), rList.get(0).getEnd_date());
		LocalDate startDate = rList.get(0).getStart_date();
        for (int i = 0; i <= daysDifference; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            List<ReviewDate> reviewDateList = new ArrayList<>();
            for(int k = 0; k < rList.size(); k++) {
            	if(rList.get(k).getPlan_date().isEqual(currentDate)) {
            		ReviewDate rD = new ReviewDate(
            				rList.get(k).getContent_id(), 
            				rList.get(k).getPlan_date(), rList.get(k).getAttraction_title(), 
            				rList.get(k).getContent_type_id());
            		reviewDateList.add(rD);
            				
            	}
            }
            dto.getList().add(reviewDateList);
        }
		return dto;
	}
}
