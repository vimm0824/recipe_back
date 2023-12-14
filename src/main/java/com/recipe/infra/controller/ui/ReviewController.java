package com.recipe.infra.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

	@GetMapping("/main")
	public String reviewList() {
		return "";
	}
	
	@GetMapping("/detail/{id}")
	public String detailReview(@PathVariable int id) {
		return "";
	}
	
	@GetMapping("/create")
	public String createReview() {
		return "";
	}
}
