package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


       
public class ReviewRegistRequestDto {
	private Long review_id;
	
	private String member_id;
	private Long plan_id;
	@NotBlank(message = "제목을 입력해 주세요")
	private String title;
	private LocalDate start_date;
	private List<String> list;
	public ReviewRegistRequestDto() {
		super();
	}
	public ReviewRegistRequestDto(Long review_id, String member_id, Long plan_id, String title, LocalDate start_date,
			List<String> list) {
		super();
		this.review_id = review_id;
		this.member_id = member_id;
		this.plan_id = plan_id;
		this.title = title;
		this.start_date = start_date;
		this.list = list;
	}
	
	
	
	@Override
	public String toString() {
		return "ReviewRegistRequestDto [review_id=" + review_id + ", member_id=" + member_id + ", plan_id=" + plan_id
				+ ", title=" + title + ", start_date=" + start_date + ", list=" + list + "]";
	}
	public Long getReview_id() {
		return review_id;
	}
	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Long getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Long plan_id) {
		this.plan_id = plan_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
}
