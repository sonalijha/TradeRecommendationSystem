package com.stockmarket.factory;


import java.util.ArrayList;
import java.util.List;


public class LargeCap implements MarketCap {
	@Override
	public List<String> getTopStocks() {
		System.out.println("inside Large Cap");

		List<String> tickers=new ArrayList<>();
		tickers.add("ACC");
		tickers.add("BHEL");
		tickers.add("YHOO");
		tickers.add("ONGC");
		tickers.add("TATAPOWERS");
		return tickers;
	}
}
