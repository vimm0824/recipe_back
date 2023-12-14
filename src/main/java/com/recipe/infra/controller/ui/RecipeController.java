package com.recipe.infra.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

	@GetMapping("/search")
	public String searchRecipe() {
		return "";
	}
	
	@GetMapping("/create")
	public String createRecipe() {
		return "";
	}
	
	@GetMapping("/detail/{recipeId}")
	public String detailRecipe(@PathVariable int recipeId) {
		return "";
	}
	
	@GetMapping("/suggest")
	public String suggestRecipe() {
		return "";
	}
	
}
