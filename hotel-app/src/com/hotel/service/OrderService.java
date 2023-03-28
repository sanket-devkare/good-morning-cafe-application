package com.hotel.service;

import java.time.LocalDate;
import java.util.List;

import com.hotel.entity.ConfirmedOrders;
import com.hotel.entity.Orders;

public interface OrderService 
{
	public ConfirmedOrders getConfirmedOrder(Orders orders);

	public Integer addConfirmedOrdersToDB(ConfirmedOrders confirmedOrders);
	
	public ConfirmedOrders getConfirmedOrdersObjectByOrderIdFromDAO(Integer orderId);
	
	public List<ConfirmedOrders> getConfirmedOrdersFromDAOByDateMoreThanEqualTo(LocalDate date);
}
