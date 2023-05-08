package com.ssafy.edu.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about(){
		return "about";
	}
	
	@GetMapping("/plan")
	public String blog() {
		return "plan/plan";
	}
	
	
}
