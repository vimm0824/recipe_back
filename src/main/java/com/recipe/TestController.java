package com.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.Caret;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recipe.infra.controller.api.openApi.RecipeOpenApi;
import com.recipe.infra.entity.UserEntity;
import com.recipe.infra.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final UserService userService;
	private final RecipeOpenApi api; 
	
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
	
	@GetMapping("/test4/{search}/{category}/{in1}/{in2}/{in3}")
	@ResponseBody
	public List<Map<String, Object>> test4(Model model,
			@PathVariable("search") String search,
			@PathVariable("category") String category,
			@PathVariable("in1") String in1,
			@PathVariable("in2") String in2,
			@PathVariable("in3") String in3
			) {
		List<String> ingredients = new ArrayList<>();
		List<Map<String, Object>> result = api.getSearchOpenRecipe(search, category, ingredients);
		return result;
	}
}
