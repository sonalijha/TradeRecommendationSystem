package com.stockmarket.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.models.Customer;
import com.stockmarket.models.Login;
import com.stockmarket.models.Stock;
//import com.stockmarket.stock.Stock;
import com.stockmarket.repositories.SRepository;
import com.stockmarket.stock.ApiStockData;
import com.stockmarket.factory.*;
import com.stockmarket.stock.*;

@Service
public class SService {
private SRepository loginRepo;

	@Autowired
	public SService(SRepository logRepository) {
		this.loginRepo = logRepository;
	}
	
	
	//This function provides service to the authenticate controller i.e. it takes 
	public boolean isValidUser(Login login){
		String username=login.getUsername();
		String password=login.getPassword();
		
		String storedPaswrd=loginRepo.getPassword(username);
		if(storedPaswrd.equals(password)){
			System.out.println("Matched paswrds");
			return true;
		}
		else
			return false;	
	}
	
	public List<Stock> getStocks(int marketCapital) {
		List<Stock> listOfStocks=new ArrayList<Stock>();
		List<Stock> stockHistory=new ArrayList<Stock>();
		List<Stock> completeHistory=new ArrayList<Stock>();
		List<String> symbolList=new ArrayList<String>();
		MarketCapFactory marketCapFactory=new MarketCapFactory();
		MarketCap marketCap;
		marketCap=marketCapFactory.getMarketCap(marketCapital);
		symbolList=loginRepo.getStockSymbols(marketCapital);
		for(int i=0;i<symbolList.size();i++){
			stockHistory=loginRepo.getStockHistoryData(symbolList.get(i));
			completeHistory.addAll(stockHistory);
		}
		System.out.println("Test"+symbolList.size());
		List<Stock> topStocks=marketCap.getTopStocks(symbolList,completeHistory);
		listOfStocks=loginRepo.getStockData(topStocks);
		
		for(int i=0;i<listOfStocks.size();i++)
		{
			System.out.println(listOfStocks.get(i).getCompanyName());
			
		}
		return listOfStocks;
	}
	public Customer getCustomerDataFromRepo(String username) {
		Customer customer=loginRepo.getCustomerDetails(username);
		return customer;
	}
	public void getApiData() throws IOException{
		List<Stock> list=new ArrayList<Stock>();
		ApiStockData stockData=new ApiStockData();
		 list=stockData.fetchStockData();
		loginRepo.updateStockData(list);
	}



	public List<Stock> getSavedStocks(String username) {
		List<Stock> stockList=loginRepo.getSavedStockData(username);
		
		return stockList;
	}



	public boolean saveStocks(Stock stock,String username) {
		System.out.println("there");
		boolean result=loginRepo.saveStocks(stock,username);
		
		return result;
	}



	public void getHistoricData() throws IOException, JSONException,ParseException {
		ApiStockData stockData=new ApiStockData();
		List<Stock> stockList=new ArrayList();
		stockList=stockData.fetchHistorialData();
		loginRepo.feedHistoricalData(stockList);
		
	}
}
