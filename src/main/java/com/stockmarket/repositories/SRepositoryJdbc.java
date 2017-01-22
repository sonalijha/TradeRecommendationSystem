package com.stockmarket.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.stockmarket.models.Customer;
import com.stockmarket.models.Stock;

@Repository
public class SRepositoryJdbc implements SRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public SRepositoryJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	

	@Override
	public String getPassword(String username)  {
		String result="";
		try{
		result = jdbc.queryForObject("select password from Users where username=?",new Object[] {username}, new RowMapper <String> (){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String password=rs.getString(1);
				return password;
			}
	
});
		}catch(EmptyResultDataAccessException e){
			result="";
		}
		return result;
	}

	@Override
	public Customer getCustomerDetails(String uname) {

		Customer result = jdbc.queryForObject("select * from Users where username=?",new Object[] {uname}, new RowMapper <Customer> (){

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setUsername(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setPassword("");
				customer.setGender(rs.getString(4));
				customer.setDateOfBirth(rs.getString(5));
				customer.setPhoneNumber(rs.getLong(6));
				customer.setEmailId(rs.getString(7));
				return customer;
			}
	
});
		return result;
	}

	@Override
	public List<Stock> getStockData(List<Stock> topStocks) {
		String list="(";
		int i;
		for( i =0;i<topStocks.size()-1;i++){
			System.out.println(topStocks.get(i).getSymbol());
			list=list+"'"+topStocks.get(i).getSymbol()+"',";
		}
		list=list+"'"+topStocks.get(i).getSymbol()+"'"+")";
		System.out.println(list);
		String query ="select * from Stocks where Symbol in "+list;
		return jdbc.query(query,
				new RowMapper<Stock>(){

					@Override
					public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
						Stock stock = new Stock();
						stock.setSymbol(rs.getString(1));
						stock.setCompanyName(rs.getString(2));
						stock.setPrice(rs.getDouble(3));
						stock.setOutstandingShares(rs.getLong(4));
						stock.setMarketCapitalization(rs.getLong(5));
						stock.setMarketCapType(rs.getString(6));
						return stock;
					}
			
		});
	}

	@Override
	public void updateStockData(List<Stock> list) {
		
	}



	@Override
	public List<Stock> getSavedStockData(String username) {
		String query="select Date_Time,Stock_Symbol, Price, No_Of_Shares from UserStocks where Username=\'"+username+"\'";
		System.out.println(query);
		return jdbc.query(query,
				new RowMapper<Stock>(){

					@Override
					public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
						Stock stock = new Stock();
						stock.setSymbol(rs.getString(2));
						stock.setPrice(rs.getDouble(3));
						stock.setOutstandingShares(rs.getInt(4));
						//stock.setDate(toString(rs.getDate(4));
						return stock;
					}
			
		});
	}

	@Override
	public List<String> getStockSymbols(int markCap){
		System.out.println("inside stock symbols function");
		List<String> symbolList=new ArrayList<>();
		System.out.println("inside getStocksymbols");
		String qry=null;
		String marketCap=null;
		if(markCap==1)
			marketCap="Small";
		else if(markCap==2)
			marketCap="Mid";
		else if(markCap==3)
			marketCap="Large";
		qry="select Symbol from Stocks where MarketCap_Type=\'"+marketCap+"\'";
		System.out.println(qry);
		symbolList= jdbc.query(qry,
				new RowMapper<String>(){

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						System.out.println(rs.getString(1));
						String symbol=(rs.getString(1));
						return symbol;
					}
			
		});
		return symbolList;
	}

	@Override
	public boolean saveStocks(Stock stock,String username) {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		int noOfRows=jdbc.update("insert into UserStocks values(?,?,?,?,?)",date,username,
					stock.getSymbol(),stock.getPrice(),stock.getOutstandingShares());
		if(noOfRows==0)
			return false;
		else 
			return true;
	}



	@Override
	public List<Stock> getStockHistoryData(String symbol) {
		{
			
			String query="select * from Historical_Data where Symbol=\'"+symbol+"\'";
			//System.out.println("inside get stock history data");
			//System.out.println(query);
			return jdbc.query(query,
					new RowMapper<Stock>(){

						@Override
						public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
							Stock stock = new Stock();
							stock.setSymbol(rs.getString(1));
							stock.setLow(rs.getDouble(3));
							stock.setHigh(rs.getDouble(4));
							return stock;
						}
				
			});
			}
		
	}



	@Override
	public void feedHistoricalData(List<Stock> stockList) {
		System.out.println("In the repo");
		for(int i=0;i<stockList.size();i++){
        jdbc.update("insert into Historical_Data values(?,?,?,?)",stockList.get(i).getSymbol(),stockList.get(i).getDate(),stockList.get(i).getHigh(),stockList.get(i).getLow());
	}	
	}	
	}

