package com.stockmarket.stock;
public class Stock {
	String symbol;
	String companyName;
	double price;
	long outstandingShares;
	double marketCapitalization;
	String marketCapType;
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	public Stock(String symbol, String companyName, double price, long outstandingShares, double marketCapitalization,
			String marketCapType) {
		super();
		this.symbol = symbol;
		this.companyName = companyName;
		this.price = price;
		this.outstandingShares = outstandingShares;
		this.marketCapitalization = marketCapitalization;
		this.marketCapType = marketCapType;
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
