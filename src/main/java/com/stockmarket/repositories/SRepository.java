package com.stockmarket.repositories;
import java.util.ArrayList;
import java.util.List;

import com.stockmarket.models.Customer;
import com.stockmarket.models.Stock;

public interface SRepository {

	String getPassword(String username);

	Customer getCustomerDetails(String username);

	List<Stock> getStockData(List<Stock> topStocks);

	void updateStockData(List<Stock> list);

	List<Stock> getSavedStockData(String username);

	boolean saveStocks(Stock stock,String username);

	public List<String> getStockSymbols(int markCap);

	public List<Stock>  getStockHistoryData(String symbol);

	void feedHistoricalData(List<Stock> stockList);
	
}
