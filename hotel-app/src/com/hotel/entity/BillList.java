package com.hotel.entity;

public class BillList 
{
	private String item;
	
	private String quantity;
	
	private Integer rate;
	
	private Integer amount;
	
	public BillList()
	{
		
	}

	public BillList(String item, String quantity, Integer rate, Integer amount) {
		this.item = item;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BillList [item=" + item + ", quantity=" + quantity + 
				", rate=" + rate + ", amount=" + amount + "]";
	}
	
}
