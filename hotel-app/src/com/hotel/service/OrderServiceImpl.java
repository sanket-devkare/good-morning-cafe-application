package com.hotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.OrderDAO;
import com.hotel.entity.ConfirmedOrders;
import com.hotel.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService 
{
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private OrderDAO orderDAO;
	
	private static final Logger log = Logger.getLogger(OrderServiceImpl.class.getName());
	
	@Override
	public ConfirmedOrders getConfirmedOrder(Orders orders) {
		
		int tableNumber = orders.getTableNumber();
		String orderDate = orders.getOrderTime().toString();
		
		String[] recipeList = orders.getRecipeList();
		Integer[] quantityList = orders.getQuantityList();
		
		Map<String, Integer> recipeQuantityMap = 
				this.createRecipeToQuantityMap(recipeList, quantityList);
		
		Long totalBill = this.getFinalBill(recipeQuantityMap);
		
		String recipeQuantity = this.createStringOfRecipeAndQuantity(recipeQuantityMap);
		
		log.info("\n Creating object of ConfirmedOrders....");
		
		ConfirmedOrders confirmedOrders =  new ConfirmedOrders(tableNumber, recipeQuantity, totalBill, orderDate);
		
		log.info("\n ConfirmedOrders = " + confirmedOrders.toString());
		
		return confirmedOrders;
	}


	private String createStringOfRecipeAndQuantity(Map<String, Integer> recipeQuantityMap) {
		
		log.info("\n recipeQuantity String...");
		StringBuilder recipeQuantityString = new StringBuilder("");
		for(Map.Entry<String, Integer> entry: recipeQuantityMap.entrySet())
		{
			recipeQuantityString.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
		}
		
		String recipeQuantity = recipeQuantityString.toString();
		log.info("\n recipeQuantity = " + recipeQuantity);
		
		
		return recipeQuantity;
	}


	private Long getFinalBill(Map<String, Integer> recipeQuantityMap) {
				
		Long totalSum = (long) 0;
		
		for(Map.Entry<String, Integer> entry: recipeQuantityMap.entrySet())
		{
			long tempPrice;
			log.info("Getting cost of recipe: " + entry.getKey());
			int recipeCost = hotelService.getRecipeCostFromDAO(entry.getKey());
			log.info("Cost of recipe: " + entry.getKey() + " is = " +  recipeCost);
			tempPrice = recipeCost * entry.getValue();
			
			totalSum = 	totalSum + tempPrice;	
		}
		
		return totalSum;
	}


	private Map<String, Integer> createRecipeToQuantityMap(String[] recipeList, 
			Integer[] quantityList) 
	{
		Map<String, Integer> recipeQuantityMap = new HashMap<>();
		
		int mapSize = recipeList.length;
		
		log.info("Creating recipeQuantityMap...");
		for(int i = 0; i <= mapSize - 1; i++)
		{
			recipeQuantityMap.put(recipeList[i], quantityList[i]);
		}
		
		log.info("recipeQuantityMap created...");
		for(Map.Entry<String, Integer> entry: recipeQuantityMap.entrySet())
		{
			log.info("recipe: " + entry.getKey() +", Quantity: " + entry.getValue());
		}
		
		return recipeQuantityMap;
	}


	@Override
	public Integer addConfirmedOrdersToDB(ConfirmedOrders confirmedOrders) 
	{		
		Integer orderId = orderDAO.addTheConfirmedOrderToDB(confirmedOrders);
		return orderId;
	}


	@Override
	public ConfirmedOrders getConfirmedOrdersObjectByOrderIdFromDAO(Integer orderId) {
		
		ConfirmedOrders confirmedOrder = orderDAO.getConfirmedOrderObjectByOrderId(orderId);
		
		return confirmedOrder;
	}


	@Override
	public List<ConfirmedOrders> getConfirmedOrdersFromDAOByDateMoreThanEqualTo(LocalDate date) {
		
		String stringDate = date.toString();
		log.info("[OrderServiceImpl] Getting Confirmed Order List for Date more than Date: " + stringDate);
		List<ConfirmedOrders> confirmedOrdersList = orderDAO
				.getConfirmedOrdersByDateMoreThanEqualTo(stringDate);
		return confirmedOrdersList;
	}

}
