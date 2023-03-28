package com.hotel.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.entity.BillList;
import com.hotel.entity.ConfirmedOrders;
import com.hotel.entity.Orders;
import com.hotel.entity.Recipe;
import com.hotel.service.HotelService;
import com.hotel.service.OrderService;
import com.hotel.util.OrderUtils;

@Controller
@RequestMapping("/hotel")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private OrderUtils orderUtils;
	
	private static final Logger log = Logger.getLogger(OrderController.class.getName());
	
	@RequestMapping("/toOrderDisplay")
	public String toOrderDisplay(@ModelAttribute("order") Orders order, Model model)
	{
		log.info("Order for table Number: " + order.getTableNumber());
		
		if(order.getRecipeList() == null || order.getRecipeList().length == 0)
		{
			String errorMessaage = "Please select atleast 1 recipe from the Menu";
			Orders order2 = new Orders();
			order2.setTableNumber(order.getTableNumber());
			List<Recipe> recipeList = hotelService.getRecipeListFromDAO();
			
			model.addAttribute("errorMessage", errorMessaage);
			model.addAttribute("availableRecipeList", recipeList);
			model.addAttribute("order", order2);
			return "order-page";
		}
		else
		model.addAttribute("order", order);
		return "order-display";
	}
	
	@RequestMapping("/toConfirmOrder")
	public String toConfirmOrder(@ModelAttribute("order") Orders order, Model model)
	{		
		order.setOrderTime(LocalDate.now());
		
		for(int i=0; i <= order.getQuantityList().length - 1; i++)
		{			
			if(order.getQuantityList()[i] == null)
			{
				order.getQuantityList()[i] = 1;
			}
		}

		ConfirmedOrders confirmedOrders = orderService.getConfirmedOrder(order);
		
		Integer orderId = orderService.addConfirmedOrdersToDB(confirmedOrders);
		
		ConfirmedOrders savedConfirmedOrder = orderService
				.getConfirmedOrdersObjectByOrderIdFromDAO(orderId);
		
		log.info("[OrderController] ConfirmedOrders : " + savedConfirmedOrder.toString());
		
		List<BillList> billList = orderUtils
				.getBillListFromConfirmedOrders(savedConfirmedOrder);
		
		log.info("[OrderController] Bill List : " + billList);
		
		model.addAttribute("savedConfirmedOrder", savedConfirmedOrder);
		model.addAttribute("billList", billList);
		
		return "confirmed-order";
	}
	
	@RequestMapping("/returnToHomePage")
	public String returnToHomePage()
	{
		return "redirect:/hotel/home";
	}
	
}
