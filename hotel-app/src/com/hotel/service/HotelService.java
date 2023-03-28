package com.hotel.service;

import java.util.List;

import com.hotel.entity.Recipe;

public interface HotelService 
{
	public List<Recipe> getRecipeListFromDAO();
	
	public List<Recipe> getAllRecipesFromDAO();
	
	public Integer getRecipeCostFromDAO(String recipe);
	
	public void saveRecipe(Recipe recipe);
	
	public Recipe getRecipeByIdFromDAO(int recipeId);
	
	public void deleteRecipeByIdFromDAO(int recipeId);
	
	public List<String> getAllRecipeNames();
}
