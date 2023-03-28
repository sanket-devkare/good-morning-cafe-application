package com.hotel.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.dao.OrderDAOImpl;
import com.hotel.entity.BillList;
import com.hotel.entity.ConfirmedOrders;
import com.hotel.service.HotelService;

@Component
public class OrderUtils 
{
	@Autowired
	private HotelService hotelService;
	
	private static final Logger log = Logger.getLogger(OrderUtils.class.getName());

	public List<BillList> getBillListFromConfirmedOrders(ConfirmedOrders savedConfirmedOrder) 
	{
		List<BillList> billList = new ArrayList<>();
		List<String> recipeList = new ArrayList<>();
		List<String> quantityList = new ArrayList<>();
		
		String recipeQuantity = savedConfirmedOrder.getRecipeQuantity();
		
		String[] recipeMapArray = recipeQuantity.split(",");

		for(int i = 0; i <= recipeMapArray.length - 1; i++)
		{
			String[] recipeQuanity = recipeMapArray[i].split("=");
			
			recipeList.add(recipeQuanity[0]);
			quantityList.add(recipeQuanity[1]);
		}
		
		List<Integer> costList = this.getCostListFromRecipeList(recipeList);
		
		List<Integer> totalCostList = this.getTotalCostListFrom(quantityList, costList);
		
		for(int i = 0; i <= recipeList.size() - 1; i++)
		{
			BillList billContent = new BillList();
			billContent.setItem(recipeList.get(i));
			billContent.setQuantity(quantityList.get(i));
			billContent.setRate(costList.get(i));
			billContent.setAmount(totalCostList.get(i));
			
			billList.add(billContent);
		}
		
		return billList;
	}

	private List<Integer> getTotalCostListFrom(List<String> quantityList, 
			List<Integer> costList) 
	{
		List<Integer> totalCostList = new ArrayList<>();
		List<Integer> tempQuantityList = new ArrayList<>();
		for(String quantityString : quantityList)
		{
			Integer quantity = Integer.parseInt(quantityString);
			tempQuantityList.add(quantity);
		}
		
		for(int i = 0; i <= costList.size() - 1; i++)
		{
			totalCostList.add(tempQuantityList.get(i) * costList.get(i));
		}
		
		return totalCostList;
	}

	private List<Integer> getCostListFromRecipeList(List<String> recipeList) {
		
		List<Integer> costList = new ArrayList<>();
		
		for(String recipe : recipeList)
		{
			Integer recipeCost = hotelService.getRecipeCostFromDAO(recipe);
			costList.add(recipeCost);
		}
		
		return costList;
	}
	
}
