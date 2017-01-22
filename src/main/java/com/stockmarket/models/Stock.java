package com.stockmarket.models;

public class Stock {
	
	String symbol;
	String companyName;
	double price;
	long outstandingShares;
	double marketCapitalization;
	String marketCapType;
	String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
	double high;
	double low;
	double rank;
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	public Stock(String symbol, String companyName, double price, long outstandingShares, double marketCapitalization,
			String marketCapType, String date, double high, double low, double rank) {
		super();
		this.symbol = symbol;
		this.companyName = companyName;
		this.price = price;
		this.outstandingShares = outstandingShares;
		this.marketCapitalization = marketCapitalization;
		this.marketCapType = marketCapType;
		this.date = date;
		this.high = high;
		this.low = low;
		this.rank = rank;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getOutstandingShares() {
		return outstandingShares;
	}
	public void setOutstandingShares(long l) {
		this.outstandingShares = l;
	}
	public double getMarketCapitalization() {
		return marketCapitalization;
	}
	public void setMarketCapitalization(double marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}
	public String getMarketCapType() {
		return marketCapType;
	}
	public void setMarketCapType(String marketCapType) {
		this.marketCapType = marketCapType;
	}
	
}
