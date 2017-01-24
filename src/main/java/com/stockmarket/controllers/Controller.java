package com.stockmarket.controllers;

import java.io.IOException;
import java.text.ParseException;
//import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.models.Login;

/*import com.stockmarket.models.Customer;
import com.stockmarket.models.Login;
import com.stockmarket.models.Stock;
import com.stockmarket.models.UserStocks;*/

@RestController
@RequestMapping("/")
public class Controller {
	private SService service;
	
	@Autowired
	public Controller(SService loginserv){
		this.service=loginserv;
	}
	
	//This controller accepts username and password and checks if the user is authentic
	@RequestMapping(value="login",method=RequestMethod.POST)
	public boolean authenticate(@RequestBody Login login){
		 return service.isValidUser(login);
	}
	
	
	//This controller displays the profile information of a user
	@RequestMapping(value="profile",method=RequestMethod.GET)
	public Customer getCustomerDetails(@RequestParam String username){
		Customer customer = service.getCustomerDataFromRepo(username);
		 return customer;
	}
	
	
	//This controller takes market cap type displays the top five stocks of that type 
	@RequestMapping(value="stocks",method=RequestMethod.GET)
	public List<Stock> getStocks(@RequestParam int marketCapType){
		List<Stock> stockList = service.getStocks(marketCapType);
		 return stockList;
	}
	
	
	//This controller display all the saved stocks of the user
	@RequestMapping(value="portfolio",method=RequestMethod.GET)
	public List<Stock> getPortfolio(@RequestParam String username){
		List<Stock> stockList = service.getSavedStocks(username);
		 return stockList;
	}
	
	
	//This controller takes the Stock price and number from user and saves them
	@RequestMapping(value="savestocks",method=RequestMethod.POST)
	public  boolean saveStocks(@RequestBody UserStocks userStocks){
		System.out.println("size ="+userStocks.getStockList().size());
		return service.saveStocks(userStocks.getStockList().get(0),userStocks.getUsername());
	}
	
	//This controller updates the Stock table and feeds the current data
	@RequestMapping(value="getLiveData",method=RequestMethod.GET)
	public  void getStockLiveData() throws IOException, JSONException {
		service.getApiData();
	}
	
	
	//This controller updates the Historical data of Stocks
	@RequestMapping(value="updatehistoricaldata",method=RequestMethod.GET)
	public  void getLiveData() throws IOException, JSONException ,ParseException{
		service.getHistoricData();
	}
	
}
