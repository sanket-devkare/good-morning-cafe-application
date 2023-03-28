package com.hotel.util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hotel.entity.AdminAnalytics;
import com.hotel.entity.ConfirmedOrders;
import com.hotel.service.HotelService;
import com.hotel.service.OrderService;

@Component
public class AdminUtils 
{
	@Autowired
	private OrderService orderService; 
	
	public boolean isUserIdAndPassWordAuthorised(String userId, String password)
	{
		Map<String, String> userIdToPasswordMap = new HashMap<>();
		this.readyTheMap(userIdToPasswordMap);
		
		if(userIdToPasswordMap.containsKey(userId))
		{
			String inBuiltPassword = userIdToPasswordMap.get(userId);
			if(inBuiltPassword.equals(password))
			{
				System.out.println("Creds Matched");
				return true;
			}
		}
		System.out.println("Creds Not Matched");
		return false;
	}
	
	public void readyTheMap(Map<String, String> userIdToPasswordMap)
	{
		userIdToPasswordMap.put("user123", "pass123");
		userIdToPasswordMap.put("userId123", "password123");
	}
	
	public AdminAnalytics getAnalytics()
	{
		LocalDate today = LocalDate.now();
		
		List<ConfirmedOrders> confirmedOrdersTodayList = orderService
				.getConfirmedOrdersFromDAOByDateMoreThanEqualTo(today);
		
		int orderCountToday = confirmedOrdersTodayList.size();
		
		LocalDate dateAWeekBefore = today.minusDays(7);
		
		List<ConfirmedOrders> confirmedOrdersWeekList = orderService
				.getConfirmedOrdersFromDAOByDateMoreThanEqualTo(dateAWeekBefore);
		
		int orderCountForWeek = confirmedOrdersWeekList.size();
		
		Long revenueToday = this.getTotalRevenueFromList(confirmedOrdersTodayList);
		
		Long weeklyRevenue = this.getTotalRevenueFromList(confirmedOrdersWeekList);
		
		AdminAnalytics adminAnalytics = new AdminAnalytics(orderCountForWeek, orderCountToday, 
				revenueToday, weeklyRevenue);
		
		return adminAnalytics;
	}
	
	private Long getTotalRevenueFromList(List<ConfirmedOrders> confirmedOrdersList)
	{
		Long totalRevenue = 0L;
		
		if(!CollectionUtils.isEmpty(confirmedOrdersList) && confirmedOrdersList.size() > 0)
		{
			for(ConfirmedOrders order : confirmedOrdersList)
			{			
				totalRevenue = totalRevenue + order.getTotalBill();
			}
		}

		return totalRevenue;
	}
	
}
