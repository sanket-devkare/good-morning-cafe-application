package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Recipe;

public interface HotelDAO 
{
	public List<Recipe> getAvailabeRecipes();
	
	public List<Recipe> getAllRecipes();
	
	public int getRecipeCostForTheGivenRecipe(String recipe);
	
	public void addRecipeToDB(Recipe recipe);
	
	public Recipe getRecipeById(int recipeId);
	
	public void deleteRecipeById(int recipeId);
}
