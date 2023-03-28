package com.hotel.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.entity.AdminAnalytics;
import com.hotel.entity.AdminLogin;
import com.hotel.entity.Recipe;
import com.hotel.service.HotelService;
import com.hotel.util.AdminUtils;

@Controller
@RequestMapping("/hotel")
public class AdminController 
{
	@Autowired
	private AdminUtils adminUtils;
	
	@Autowired
	private HotelService hotelService;
	
	private static final Logger log = Logger.getLogger(AdminController.class.getName());
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		StringTrimmerEditor StringTrimmerEditor = new  
		StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, StringTrimmerEditor);
	}
	
	/**
	 * Method to check the authenticate the admin userid and password
	 * will return the same empty login form if user is not authenticated
	 * @param adminLogin
	 * @return
	 */
	@RequestMapping("/adminControl")
	public String adminControll(@ModelAttribute("adminLogin") AdminLogin adminLogin, 
			Model model)
	{
		System.out.println("UserId :" + adminLogin.getUserId());
		System.out.println("Password :" + adminLogin.getPassword());
		
		if(adminUtils.isUserIdAndPassWordAuthorised(adminLogin.getUserId(), 
				adminLogin.getPassword()))
		{
			AdminAnalytics analytics = adminUtils.getAnalytics();
			model.addAttribute("analytics", analytics);
			return "admin-analytics";
		}
		else
		{
			AdminLogin adminLogin2 = new AdminLogin();
			String errorMessage = "Invalid Username or Password";
			
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("adminLogin", adminLogin2);
			return "admin-login-form";
		}
	}
	
	@RequestMapping("/showRecipeList")
	public String showRecipeList(Model model)
	{
		List<Recipe> recipeList = hotelService.getAllRecipesFromDAO();
		model.addAttribute("recipeList", recipeList);
		return "admin-control-setup";
	}
	
	@RequestMapping("/showRecipeForm")
	public String addRecipeForm(Model model)
	{
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);
		return "recipe-form";
	}
	
	@RequestMapping("/addRecipe")
	public String addRecipeFromForm(@Valid @ModelAttribute("recipe") Recipe recipe, 
			BindingResult bindingResult, Model model)
	{
		List<String> recipeNameListInLowerCase = hotelService.getAllRecipeNames();
		
		if(recipe.getRecipeName() == null)
		{
			String errorMessage = "Please enter a valid recipe name";
			model.addAttribute("recipe", recipe);
			model.addAttribute("recipeErrorMesage", errorMessage);
			return "recipe-form";
		}
		else if(recipeNameListInLowerCase.contains(recipe.getRecipeName().toLowerCase()) 
				&& (recipe.getRecipeId() == 0))
		{
			String errorMessage = "The Recipe Name Already Exists";
			model.addAttribute("recipe", recipe);
			model.addAttribute("recipeErrorMesage", errorMessage);
			return "recipe-form";
		}
		else if(recipe.getCost() == 0)
		{
			String errorMessage = "Cost for the Recipe cannot be 0";
			model.addAttribute("recipe", recipe);
			model.addAttribute("costErrorMesage", errorMessage);
			return "recipe-form";
		}
		
		else
		log.info("Recipe recieved : " + recipe);
		
		hotelService.saveRecipe(recipe);

		return "redirect:/hotel/showRecipeList";
	}
	
	@RequestMapping("/showAdminAnalyticsPage")
	public String showAdminAnalyticsPage(Model model)
	{
		
		return "admin-analytics";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("recipeId") int recipeId, Model model)
	{
		log.info("The Request Param (for update) RecipeId: " + recipeId);
		Recipe recipe = hotelService.getRecipeByIdFromDAO(recipeId);
		model.addAttribute("recipe", recipe);
		return "recipe-form";
	}
	
	@RequestMapping("/deleteRecipe")
	public String deleteRecipe(@RequestParam("recipeId") int recipeId, Model model)
	{
		log.info("The Request Param (to delete) RecipeId: " + recipeId);
		hotelService.deleteRecipeByIdFromDAO(recipeId);
		return "redirect:/hotel/showRecipeList";
	}
	
}
