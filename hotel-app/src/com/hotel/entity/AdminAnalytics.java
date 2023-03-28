package com.hotel.entity;

public class AdminAnalytics 
{
	private int orderCountWeek;
	
	private int orderCountToday;
	
	private Long revenueToday;
	
	private Long revenueThisWeek;
	
	public AdminAnalytics()
	{
		
	}

	public AdminAnalytics(int orderCountWeek, int orderCountToday, 
			Long revenueToday, Long revenueThisWeek) {
		this.orderCountWeek = orderCountWeek;
		this.orderCountToday = orderCountToday;
		this.revenueToday = revenueToday;
		this.revenueThisWeek = revenueThisWeek;
	}

	public int getOrderCountWeek() {
		return orderCountWeek;
	}

	public void setOrderCountWeek(int orderCountWeek) {
		this.orderCountWeek = orderCountWeek;
	}

	public int getOrderCountToday() {
		return orderCountToday;
	}

	public void setOrderCountToday(int orderCountToday) {
		this.orderCountToday = orderCountToday;
	}

	public Long getRevenueToday() {
		return revenueToday;
	}

	public void setRevenueToday(Long revenueToday) {
		this.revenueToday = revenueToday;
	}

	public Long getRevenueThisWeek() {
		return revenueThisWeek;
	}

	public void setRevenueThisWeek(Long revenueThisWeek) {
		this.revenueThisWeek = revenueThisWeek;
	}

	@Override
	public String toString() {
		return "AdminAnalytics [orderCountWeek=" + orderCountWeek + ", orderCountToday=" + orderCountToday
				+ ", revenueToday=" + revenueToday + ", revenueThisWeek=" + revenueThisWeek + "]";
	}
	
}
