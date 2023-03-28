package com.hotel.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Orders 
{
	
	private int tableNumber;
	
	private String[] recipeList;
	
	private LocalDate orderTime;
	
	private Integer[] quantityList;
	
	public Orders()
	{
		
	}


	public String[] getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(String[] recipeList) {
		this.recipeList = recipeList;
	}

	public LocalDate getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDate orderTime) {
		this.orderTime = orderTime;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Integer[] getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(Integer[] quantityList) {
		this.quantityList = quantityList;
	}


	@Override
	public String toString() {
		return "Orders [tableNumber=" + tableNumber + ", recipeList=" + Arrays.toString(recipeList) + ", orderTime="
				+ orderTime + ", quantityList=" + Arrays.toString(quantityList) + "]";
	}
	
	

}
