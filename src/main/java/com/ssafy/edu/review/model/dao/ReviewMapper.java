package com.ssafy.edu.review.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseEntity;

@Mapper
public interface ReviewMapper {

	List<MyPlanResponseDto> planList(String id);

	List<MyPlanReviewResponseEntity> myPlanReview(String pid);

}
