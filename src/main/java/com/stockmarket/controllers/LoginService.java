package com.stockmarket.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.customer.Customer;
import com.stockmarket.login.Login;
//import com.stockmarket.stock.Stock;
import com.stockmarket.repositories.LoginRepository;
import com.stockmarket.stock.Stock;
import com.stockmarket.factory.*;

@Service
public class LoginService {
private LoginRepository loginRepo;

	@Autowired
	public LoginService(LoginRepository logRepository) {
		this.loginRepo = logRepository;
	}
	
	
	
	public boolean isValidUser(Login login){
		//Customer customer = new Customer();
		String username=login.getUsername();
		String password=login.getPassword();
		
		String storedPaswrd=loginRepo.getPassword(username);
		//System.out.println("Password from user: "+password);
		//System.out.println("Password from db: "+storedPaswrd);
		if(storedPaswrd.equals(password)){
			System.out.println("Matched paswrds");
			//customer.setUsername(username);
			return true;
		}
		else
			return false;	
	}
	
	public List<Stock> getStocks(int marketCapital) {
		List<Stock> listOfStocks=new ArrayList<Stock>();
		MarketCapFactory marketCapFactory=new MarketCapFactory();
		MarketCap marketCap;
		marketCap=marketCapFactory.getMarketCap(marketCapital);
		//To be done
		List<String> tickers=marketCap.getTopStocks();
		listOfStocks=loginRepo.getStockData(tickers);
		
		for(int i=0;i<listOfStocks.size();i++)
		{
			System.out.println(listOfStocks.get(i).getCompanyName());
			
		}
		return listOfStocks;
	}
	public Customer getCustomerDataFromRepo(String username) {
		Customer customer=loginRepo.getCustomerDetails(username);
		
		/*Customer customer=new Customer();
		customer.setName("SonaliJha");
		customer.setEmailId("sonali@gmail.com");
		customer.setGender("female");
		customer.setUsername(username);*/
		return customer;
	}
	public void getApiData() throws IOException{
		List<Stock> list=new ArrayList<Stock>();
		//list=stockData.fetchStockData();
		loginRepo.updateStockData(list);
	}



	public List<Stock> getSavedStocks(String username) {
		List<Stock> stockList=loginRepo.getSavedStockData(username);
		
		return stockList;
	}



	public boolean saveStocks(List<Stock> stockList) {
		boolean result=loginRepo.saveStocks(stockList);
		
		return result;
	}
}
