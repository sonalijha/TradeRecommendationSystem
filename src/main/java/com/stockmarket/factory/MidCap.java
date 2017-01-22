package com.stockmarket.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.stockmarket.customer.Customer;
import com.stockmarket.repositories.LoginRepository;
import com.stockmarket.stock.Stock;
import com.stockmarket.controllers.LoginService;

public class MidCap extends MarketCap {
	
	LoginRepository loginRepo;
	

	@Override
	public List<String> getTopStocks(){
		System.out.println("inside mid Cap");
		
		
		List<String> stockSymbols=loginRepo.getStockSymbols(2000000000,10000000000L);
		//double[] rank=new float[stockHistory.size()];
		List<Stock> stockHistory=new ArrayList<>();
		// foo(stockSymbols)
		for(int i=0;i<stockSymbols.size();i++)
		{
			stockHistory.get(i).setSymbol(stockSymbols.get(i));
			stockHistory.get(i).setRank(getTopFive(stockSymbols.get(i)));
					
		}
		Collections.sort(stockHistory,new Comparator<Stock>(){
			public int compare(Stock s1,Stock s2){
				double res= (s1.getRank()-(s2.getRank()));
				if(res<0)
					return -1;
				else if(res>0)
					return 1;
				else
					return 0;
				
				
			}
		}
				);

		List<String> topFive=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			topFive.add(stockHistory.get(i).getSymbol());
		}
		
		return topFive;

		//List<String> tickers=new ArrayList<>();
		
		/*tickers.add("ACC");
		tickers.add("BHEL");
		tickers.add("YHOO");
		tickers.add("ONGC");
		tickers.add("TATAPOWERS");*/
		//return tickers;
	}
	
	public double getTopFive(String symbol)
	{
		List<Stock> stockHistory=loginRepo.getStockHistoryData(symbol);
		double[] dailyAvg=new double[stockHistory.size()];
		for(int i=0;i<stockHistory.size();i++)
		{
			dailyAvg[i]=(stockHistory.get(i).getHigh()+stockHistory.get(i).getLow())/2;
			
		}
		double sum=0.0;
		double avgDifference=0.0;
		for(int i=1;i<stockHistory.size();i++)
		{
			avgDifference=dailyAvg[i]-dailyAvg[i-1];
			sum=sum+avgDifference;
		}
		
		return  sum;
		
	}

}
