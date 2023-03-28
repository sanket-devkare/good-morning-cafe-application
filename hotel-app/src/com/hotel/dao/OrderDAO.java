package com.hotel.dao;

import java.util.List;

import com.hotel.entity.ConfirmedOrders;

public interface OrderDAO 
{
	public Integer addTheConfirmedOrderToDB(ConfirmedOrders confirmedOrders);
	
	public ConfirmedOrders getConfirmedOrderObjectByOrderId(Integer orderId);
	
	public List<ConfirmedOrders> getConfirmedOrdersByDateMoreThanEqualTo(String date);
}
