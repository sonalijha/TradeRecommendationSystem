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
		String list="(";
		int i;
		for( i =0;i<tickers.size()-1;i++){
			list=list+"'"+tickers.get(i)+"',";
		}
		list=list+"'"+tickers.get(i)+"'"+")";
		System.out.println(list);
		String query ="select * from Stocks where Symbol in "+list;
		System.out.println(query);

		return jdbc.query(query,
				new RowMapper<Stock>(){

					@Override
					public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
						Stock stock = new Stock();
						stock.setSymbol(rs.getString(1));
						stock.setCompanyName(rs.getString(2));
						stock.setPrice(rs.getDouble(3));
						stock.setOutstandingShares(rs.getInt(4));
						stock.setMarketCapitalization(rs.getDouble(5));
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
		String query="select Stock_Symbol, Stock_Price, No_Of_Stocks from UserStocks where Username=\'"+username+"\'";
		System.out.println("...................");
		return jdbc.query(query,
				new RowMapper<Stock>(){

					@Override
					public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
						Stock stock = new Stock();
						stock.setSymbol(rs.getString(1));
						stock.setPrice(rs.getDouble(2));
						stock.setOutstandingShares(rs.getInt(3));
						return stock;
					}
			
		});
		/*stocks.add(new Stock("hhhh", "A C C", 1000, 5000000, 20000000, "SMALL"));
		stocks.add(new Stock("yyy", "O N G C", 1000, 5000000, 90000000, "Large"));
		*/
		
		//return stocks;
	}

@Override
public List<String> getStockSymbols(int from, long to){
	List<String> symbolList=new ArrayList<>();
	symbolList.add("ACC");
	symbolList.add("BHEL");
	symbolList.add("ONGC");
	return symbolList;
}

	@Override
	public boolean saveStocks(List<Stock> stockList,String username) {
		int noOfRows=0;
		for(int i=0;i<stockList.size();i++){
			noOfRows=jdbc.update("insert into UserStocks values(?,?,?,?)",username,
					stockList.get(i).getSymbol(),stockList.get(i).getPrice(),stockList.get(i).getOutstandingShares());
		}
		if(noOfRows==0)
			return false;
		else 
			return true;
	}



	@Override
	public List<Stock> getStockHistoryData(String symbol) {
		List<Stock> historyList=new ArrayList<>();
		/*Stock stocks=new Stock();
		stocks.add(new Stock("hhhh", "A C C", 1000, 5000000, 20000000, "SMALL",'01-aug-98',189.00,67.00,1));
		stocks.add(new Stock("yyy", "O N G C", 1000, 5000000, 90000000, "Large","01-aug-98",189.00,67.00,1));*/
		return null;
	}

}
