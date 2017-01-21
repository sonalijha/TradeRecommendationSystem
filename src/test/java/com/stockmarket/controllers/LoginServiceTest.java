/*package com.stockmarket.controllers;

import com.stockmarket.login.*;
//import com.stockmarket.customer.*;
import com.stockmarket.repositories.LoginRepository;
import com.stockmarket.stock.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.dao.EmptyResultDataAccessException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class LoginServiceTest {
	
	@Mock
	LoginRepository loginRepoMock;
	//=Mockito.mock(LoginRepository.class);
	
	@Autowired
	LoginService loginService=new LoginService(loginRepoMock);
	List<Stock> listOfStocks_actual=new ArrayList<Stock>();
	List<Stock> listOfStocks_expected=new ArrayList<Stock>();
	Stock stock=new Stock();
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testisValidUser_SuccessScenario() {
		Login login=new Login();
		login.setUsername("Sonali");
		login.setPassword("Jha");
		//Mockito.when(loginRepoMock.getPassword("Sonali")).thenReturn("Sonali");
		
		boolean actual=loginService.isValidUser(login);
		assertTrue(actual);
		
		//Mockito.verify(loginRepoMock).getPassword("Sonali");
		//Customer expected=new Customer();
		//expected.setUsername("username");
		//assertEquals(expected.getUsername(),actual.getUsername());
		
	}
	
	@Test
	public void testisValidUser_WrongPassword(){
		Login login=new Login();
		login.setUsername("Sonali");
		login.setPassword("jha");
		boolean actual=loginService.isValidUser(login);
		assertFalse(actual);
		
	}
	
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void testisValidUser_WrongUsername(){
		Login login=new Login();
		login.setUsername("sonali");
		login.setPassword("jha");
		boolean actual=loginService.isValidUser(login);
		assertFalse(actual);
		
	}
	
	@Test
	public void testcallToFactory_MiddCap(){
		
		listOfStocks_actual=loginService.callToFactory(1);
		listOfStocks_expected=loginRepoMock.getStockData("select * from Stocks where Market_Capitalization<=10000000000 and Market_Capitalization>=300000000");
		int i=0;
		while(!listOfStocks_expected.isEmpty())
		{
			assertEquals(listOfStocks_expected.get(i).getMarketCapType(),listOfStocks_actual.get(i).getMarketCapType());
			i++;
		}
		
	}

}


*/

