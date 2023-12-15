package com.recipe.infra.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserUiController {

	/**
	 *	로그인 ui 
	 */
	@GetMapping("/log_in")
	public String logIn() {
		return "user/login";
	}
	
	/**
	 * 회원가입 ui 
	 */
	@GetMapping("/sign_up")
	public String signUp() {
		return "user/signup"; 
	}
	/**
	 * 비밀번호 찾기 ui
	 */
	@GetMapping("/find_password")
	public String findPassword() {
		return "user/email";
	}
}
