package com.stockmarket.factory;
import java.util.List;

import com.stockmarket.models.Stock;

public interface MarketCap {

	public List<Stock> getTopStocks(List<String> stockSymbols,List<Stock> StockHistory);
	public double getTopFive(String symbol,List<Stock> StockHistoryData);
}