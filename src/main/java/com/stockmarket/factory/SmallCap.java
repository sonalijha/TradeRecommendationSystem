package com.stockmarket.factory;

import java.util.ArrayList;
import java.util.List;

import com.stockmarket.customer.Customer;
import com.stockmarket.stock.Stock;

public class SmallCap implements MarketCap{

	@Override
	public List<String> getTopStocks() {
		System.out.println("inside Small Cap");
		List<String> tickers=new ArrayList<>();
		tickers.add("ACC");
		tickers.add("BHEL");
		tickers.add("YHOO");
		tickers.add("ONGC");
		tickers.add("TATAPOWERS");
		return tickers;
	}
	
}
