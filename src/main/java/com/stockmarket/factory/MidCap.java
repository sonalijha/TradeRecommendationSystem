package com.stockmarket.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.stockmarket.models.Stock;
import com.stockmarket.repositories.SRepository;

public class MidCap implements MarketCap {
	
	SRepository loginRepo;
	
	public MidCap()
	{
		
	}
	
	public List<Stock> getTopStocks(List<String> listOfSymbols,List<Stock> stockHistoryData){
		List<Stock> stocks=new ArrayList<>();
		for(int i=0;i<listOfSymbols.size();i++)
		{
			
			Stock stock=new Stock();
			stock.setSymbol(listOfSymbols.get(i));
			stock.setRank(getTopFive(listOfSymbols.get(i),stockHistoryData));
			
			stocks.add(stock);
			
			
		}
		
		
		Collections.sort(stocks,new Comparator<Stock>(){
			public int compare(Stock s1,Stock s2){
				if(s1.getRank()<(s2.getRank()))
					return -1;
				else if(s1.getRank()>(s2.getRank()))
					return 1;
				else
					return 0;
				
				
			}
		}
				);
		
		List<Stock> topFive=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			topFive.add(stocks.get(i));
		}
		
		return topFive;

	}
	
	public double getTopFive(String Symbol,List<Stock> stockHistoryData)
	{
		List<Stock> stockHistory = new ArrayList<>();
		
		for(int i=0;i<stockHistoryData.size();i++)
		{
			if(stockHistoryData.get(i).getSymbol().equals(Symbol)){
				stockHistory.add(stockHistoryData.get(i));
			}
			
		}
		
		double[] dailyAvg=new double[stockHistory.size()];
		for(int i=0;i<stockHistory.size();i++)
		{
			dailyAvg[i]=(stockHistory.get(i).getHigh()+stockHistory.get(i).getLow())/2;
			
		}
		double growth=0.0;
		double dailyAvgDifference=0.0;
		for(int i=1;i<stockHistory.size();i++)
		{
			dailyAvgDifference=dailyAvg[i]-dailyAvg[i-1];
			growth=growth+dailyAvgDifference;
		}
		return  growth;
		
	}
}
