package com.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.HotelDAO;
import com.hotel.entity.Recipe;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public List<Recipe> getRecipeListFromDAO() 
	{
		List<Recipe> recipeList = hotelDAO.getAvailabeRecipes();
		System.out.println("Recipes in service :" + recipeList);
		
		return recipeList;
	}

	@Override
	public Integer getRecipeCostFromDAO(String recipe) {
		
		Integer recipeCost = hotelDAO.getRecipeCostForTheGivenRecipe(recipe);
		
		return recipeCost;
	}

	@Override
	public void saveRecipe(Recipe recipe) {
		
		hotelDAO.addRecipeToDB(recipe);
	}

	@Override
	public List<Recipe> getAllRecipesFromDAO() {
		
		List<Recipe> recipeList = hotelDAO.getAllRecipes();
		
		return recipeList;
	}

	@Override
	public Recipe getRecipeByIdFromDAO(int recipeId) {
		
		Recipe recipe = hotelDAO.getRecipeById(recipeId);
		
		return recipe;
	}

	@Override
	public void deleteRecipeByIdFromDAO(int recipeId) {
		
		hotelDAO.deleteRecipeById(recipeId);
	}

	@Override
	public List<String> getAllRecipeNames() 
	{
		List<String> recipeNameList = new ArrayList<>();
		List<Recipe> recipeList = this.getAllRecipesFromDAO();
		
		for(Recipe recipe: recipeList)
		{
			recipeNameList.add(recipe.getRecipeName().toLowerCase());
		}
		
		return recipeNameList;
	}

}
