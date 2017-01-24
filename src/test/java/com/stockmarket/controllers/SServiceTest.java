/*package com.stockmarket.controllers;

import com.stockmarket.application.*;
import com.stockmarket.models.Login;
import com.stockmarket.models.Stock;
//import com.stockmarket.customer.*;
import com.stockmarket.repositories.SRepository;
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
public class SServiceTest {
	
	@Mock
	SRepository loginRepoMock;
	//=Mockito.mock(LoginRepository.class);
	
	@Autowired
	SService loginService=new SService(loginRepoMock);
	List<Stock> listOfStocks=new ArrayList<Stock>();
	//List<Stock> listOfStocks_expected=new ArrayList<Stock>();
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
	public void testgetStocks(){
		
		listOfStocks=loginService.getStocks(3);
		int i;
	
		for(i=0;i<listOfStocks.size();i++)
		{
			assertEquals("Large",listOfStocks.get(i).getMarketCapType());
		}
		
	}

}


*/

