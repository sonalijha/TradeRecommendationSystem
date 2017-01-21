package com.stockmarket.factory;

public class MarketCapFactory {
	public MarketCap getMarketCap(int type){
		MarketCap mc=null;
		switch(type){
		case 1:
			mc=new SmallCap();
			break;
		case 2:
			mc=new MidCap();
			break;
		case 3:
			mc=new LargeCap();
			break;
		}
		return mc;
	}
}
