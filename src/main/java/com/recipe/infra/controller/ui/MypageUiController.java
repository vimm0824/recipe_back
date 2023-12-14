package com.recipe.infra.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageUiController {

	@GetMapping("/info/{userId}")
	public String userInfo(@PathVariable Long userId) {
		return "";
	}
	
	@GetMapping("")
	public String updateUser() {
		return "";
	}
	
}
