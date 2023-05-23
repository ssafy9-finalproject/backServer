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
import com.ssafy.edu.review.model.dto.ReviewContentRegistDto;
import com.ssafy.edu.review.model.dto.ReviewDate;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewDailyModel;
import com.ssafy.edu.review.model.dto.SingleReviewMapperDto;
import com.ssafy.edu.review.model.dto.SingleReviewResponseDto;

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
	@Transactional
	@Override
	public void registReview(ReviewRegistRequestDto dto) {
		reviewMapper.registReview(dto);
		LocalDate startDate = dto.getStart_date();
		for(int i = 0; i < dto.getList().size(); i++) {
			ReviewContentRegistDto rDto = new ReviewContentRegistDto(dto.getReview_id(), dto.getList().get(i), startDate);
			reviewMapper.registReviewContent(rDto);
			startDate = startDate.plusDays(1);
		}
	}
	@Override
	public List<ReviewListResponseDto> reviewList() {
		return reviewMapper.reviewList();
	}
	@Override
	public SingleReviewResponseDto getReview(Long id) {
		List<SingleReviewMapperDto> mapperList = reviewMapper.getReview(id);
		SingleReviewResponseDto dto = new SingleReviewResponseDto();
		dto.setTitle(mapperList.get(0).getTitle());
		dto.setHit(mapperList.get(0).getHit());
		
		List<SingleReviewDailyModel> dailyModelList = new ArrayList<SingleReviewDailyModel>();
		long daysDifference = ChronoUnit.DAYS.between(mapperList.get(0).getStart_date(), mapperList.get(0).getEnd_date());
		LocalDate theDay = mapperList.get(0).getStart_date();
		
		for(int i = 0; i <= daysDifference; i++) {
			SingleReviewDailyModel dailyModel = new SingleReviewDailyModel();
			dailyModel.setReviewDate(theDay);
			for(int j = 0; j < mapperList.size(); j++) {
				if(mapperList.get(j).getReview_date().isEqual(theDay)) {
					dailyModel.setContents(mapperList.get(j).getContents());
					break;
				}
			}
			
			List<String> attractionNameList = new ArrayList<String>();
			List<Integer> contentTypeList = new ArrayList<Integer>();
			
			for(int j = 0; j < mapperList.size(); j++) {
				if(mapperList.get(j).getReview_date().isEqual(theDay)) {
					attractionNameList.add(mapperList.get(j).getAttractionName());
					contentTypeList.add(mapperList.get(j).getContent_type_id());
				}
			}
			
			dailyModel.setAttractionName(attractionNameList);
			dailyModel.setContentType(contentTypeList);
			
			dailyModelList.add(dailyModel);
			theDay = theDay.plusDays(1);
		}
		dto.setDailyList(dailyModelList);
		return dto;
	}
}
