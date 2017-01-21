package com.stockmarket.repositories;
import java.util.List;

import com.stockmarket.customer.Customer;
import com.stockmarket.stock.Stock;

public interface LoginRepository {

	String getPassword(String username);

	Customer getCustomerDetails(String username);

	List<Stock> getStockData(List<String> tickers);

	void updateStockData(List<Stock> list);

	List<Stock> getSavedStockData(String username);

	boolean saveStocks(List<Stock> stockList);

}
