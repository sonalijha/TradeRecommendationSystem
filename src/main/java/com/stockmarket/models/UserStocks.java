package com.stockmarket.models;

import java.util.List;

import com.stockmarket.stock.Stock;

public class UserStocks {
	String username;
	List<Stock> stockList;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	
}
