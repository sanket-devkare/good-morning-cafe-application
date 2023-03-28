package com.hotel.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIRMED_ORDERS")
public class ConfirmedOrders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDERID")
	private int orderId;
	
	@Column(name = "TABLE_NUMBER")
	private int tableNumber;
	
	@Column(name = "RECIPE_QUANTITY")
	private String recipeQuantity;
	
	@Column(name = "TOTAL_BILL")
	private Long totalBill;
	
	@Column(name = "ORDER_DATE")
	private String orderDate;
	
	public ConfirmedOrders()
	{
		
	}
	
	public ConfirmedOrders(int tableNumber, String recipeQuantity, 
			Long totalBill, String orderDate) 
	{
		this.tableNumber = tableNumber;
		this.recipeQuantity = recipeQuantity;
		this.totalBill = totalBill;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getRecipeQuantity() {
		return recipeQuantity;
	}

	public void setRecipeQuantity(String recipeQuantity) {
		this.recipeQuantity = recipeQuantity;
	}

	public Long getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Long totalBill) {
		this.totalBill = totalBill;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "ConfirmedOrders [orderId=" + orderId + ", tableNumber=" + tableNumber + ", recipeQuantity="
				+ recipeQuantity + ", totalBill=" + totalBill + ", orderDate=" + orderDate + "]";
	}

}
