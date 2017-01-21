package com.stockmarket.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.stockmarket.customer.Customer;
import com.stockmarket.stock.Stock;

@Repository
public class LoginRepositoryJdbc implements LoginRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public LoginRepositoryJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	

	/*@Override
	public List<Login> findAll() {

		return jdbc.query("select username,password from Users order by lastName", new RowMapper<Login>() {

			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				Login login = new Login();
				login.setUsername(rs.getString(1));
				login.setPassword(rs.getString(2));
				return login;
			}

		});
	}*/

	@Override
	public String getPassword(String username) {
		String result="";
		result = jdbc.queryForObject("select password from Users where username=?",new Object[] {username}, new RowMapper <String> (){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String password=rs.getString(1);
				return password;
			}
	
});
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
				customer.setPassword(rs.getString(3));
				customer.setGender(rs.getString(4));
				customer.setDateOfBirth(rs.getString(5));
				customer.setPhoneNumber(rs.getLong(6));
				customer.setEmailId(rs.getString(7));
				customer.setMarketCapType(rs.getString(8));
				return customer;
			}
	
});
		return result;
	}

	@Override
	public List<Stock> getStockData(List<String> tickers) {
		/*return jdbc.query(que, 
				new RowMapper<Stock>(){

					@Override
					public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
						Stock stock = new Stock();
						stock.setSymbol(rs.getString(2));
						stock.setCompanyName(rs.getString(3));
						stock.setPrice(rs.getDouble(4));
						stock.setOutstandingShares(rs.getInt(5));
						stock.setMarketCapitalization(rs.getDouble(6));
						stock.setMarketCapType(rs.getString(7));
						return stock;
					}
			
		});*/
		List<Stock> stocks=new ArrayList<>();
		stocks.add(new Stock("ACC", "A C C", 1000, 5000000, 20000000, "SMALL"));
		stocks.add(new Stock("ONGC", "O N G C", 1000, 5000000, 90000000, "Large"));
		
		return stocks;
	}

	@Override
	public void updateStockData(List<Stock> list) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Stock> getSavedStockData(String username) {
		List<Stock> stocks=new ArrayList<>();
		stocks.add(new Stock("hhhh", "A C C", 1000, 5000000, 20000000, "SMALL"));
		stocks.add(new Stock("yyy", "O N G C", 1000, 5000000, 90000000, "Large"));
		
		
		return stocks;
	}



	@Override
	public boolean saveStocks(List<Stock> stockList) {
		System.out.println("size ="+stockList.size());
		if(stockList.isEmpty())
			return false;
		else 
			return true;
	}

}
