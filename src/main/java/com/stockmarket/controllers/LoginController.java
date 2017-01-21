package com.stockmarket.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.stockmarket.controllers.*;
import com.stockmarket.*;
import com.stockmarket.customer.Customer;
import com.stockmarket.login.Login;
import com.stockmarket.stock.Stock;

@RestController
@RequestMapping("/")
public class LoginController {
	private LoginService loginservice;
	
	@Autowired
	public LoginController(LoginService loginserv){
		this.loginservice=loginserv;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public boolean authenticate(@RequestBody Login login){
		 return loginservice.isValidUser(login);
	}
	
	@RequestMapping(value="dashboard",method=RequestMethod.GET)
	public Customer getCustomerDetails(@RequestParam String username){
		Customer customer = loginservice.getCustomerDataFromRepo(username);
		 return customer;
	}
	
	@RequestMapping(value="stocks",method=RequestMethod.GET)
	public List<Stock> getStocks(@RequestParam int marketCapType){
		List<Stock> stockList = loginservice.getStocks(marketCapType);
		 return stockList;
	}
	
	@RequestMapping(value="portfolio",method=RequestMethod.GET)
	public List<Stock> getPortfolio(@RequestParam String username){
		List<Stock> stockList = loginservice.getSavedStocks(username);
		 return stockList;
	}
	
	
	
	
	@RequestMapping(value="savestocks",method=RequestMethod.POST)
	public  boolean saveStocks(@RequestBody ArrayList<Stock> stockList){
		System.out.println("size ="+stockList.size());
		return loginservice.saveStocks(stockList);
	}
	
	/*@RequestMapping(value="getLiveData",method=RequestMethod.GET)
	public  void getLiveData() throws IOException, JSONException {
		loginservice.getApiData();
	}
	*/
}
