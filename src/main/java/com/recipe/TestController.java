package com.recipe;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recipe.infra.entity.UserEntity;
import com.recipe.infra.service.UserService;

@Controller
public class TestController {

	private final UserService userService;
	
	public TestController(UserService userService) {
		this.userService = userService;
	}
	
	@ResponseBody
	@GetMapping("/test1")
	public String test1() {
		return "바보";
	}
	
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2() {
		Map<String, Object> result = new HashMap<>();
		result.put("test1", 1);
		result.put("test2", 2);
		return result;
	}
	
	@ResponseBody
	@GetMapping("/test3")
	public UserEntity test3() {
		return userService.getUserById(1L);
	}
}
