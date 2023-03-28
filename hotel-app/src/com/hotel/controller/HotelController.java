package com.hotel.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.dao.HotelDAO;
import com.hotel.entity.AdminLogin;
import com.hotel.entity.Orders;
import com.hotel.entity.Recipe;
import com.hotel.service.HotelService;
import com.hotel.util.AdminUtils;

@Controller
@RequestMapping("/hotel")
public class HotelController
{
	@Autowired
	private HotelDAO hotelDAO;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AdminUtils adminUtils;
	
	/**
	 * controller method to display all the available recipes in UI
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")  // /hotel/home
	public String getHoepage(Model model)
	{
		System.out.println("Inside controller...");
		List<Recipe> recipeList = hotelService.getRecipeListFromDAO();
		
		for(Recipe recipe : recipeList)
		{
			System.out.println(recipe);
		}
		
		model.addAttribute("recipeList", recipeList);
		
		return "hotel-homepage";
	}
	
	/**
	 * Controller method to trigger Admin login page
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String adminLoginPage(Model model)
	{
		AdminLogin adminLogin = new AdminLogin();
		model.addAttribute(adminLogin);
		return "admin-login-form";
	}
	

	
	@RequestMapping("/orderPage")
	public String toOrderPage(Model model)
	{
		List<Recipe> availableRecipeList = new ArrayList<>();
		Orders order = new Orders();
		List<Recipe> recipeList = hotelService.getRecipeListFromDAO();
		
		model.addAttribute("availableRecipeList", recipeList);
		model.addAttribute("order", order);
		
		return "order-page";
	}
	

}
