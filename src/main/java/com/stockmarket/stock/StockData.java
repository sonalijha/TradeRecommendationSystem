package com.stockmarket.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.stockmarket.models.Stock;



public class StockData {
	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	 
	 public static String readFromUrl(String url) throws IOException{
		  String resultHistoricalData;
		  InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String str = readAll(rd);
		      resultHistoricalData=str;
		    }finally {
		        is.close();
		    }
		  return resultHistoricalData;
	  }
	 
	 public List<Stock> fetchHistorialData() throws IOException,ParseException
	 {System.out.println("Historical stock quotes of each company : ");
     //to get data from 15 days back acc to calendar to yesterday's date
     DateFormat extractYear = new SimpleDateFormat("yyyy");
     DateFormat extractMonth = new SimpleDateFormat("MMM");
     DateFormat extractDay = new SimpleDateFormat("dd");
     DateFormat date=new SimpleDateFormat("MMM dd, yyyy");
     DateFormat dateSqlFormat=new SimpleDateFormat("dd-MMM-yy");
     
     
     //Getting yesterday's date
     Calendar cal1 = Calendar.getInstance();
     cal1.add(Calendar.DATE, -1);
     Date toDate = cal1.getTime();    
     String toDateDay = extractDay.format(toDate);
     String toDateMonth= extractMonth.format(toDate);
     String toDateYear= extractYear.format(toDate);
     
     //Getting date before 15 days from today
     Calendar cal2 = Calendar.getInstance();
     cal2.add(Calendar.DATE, -15);
     Date fromDate = cal2.getTime();    
     String fromDateDay = extractDay.format(fromDate);
     String fromDateMonth= extractMonth.format(fromDate);
     String fromDateYear= extractYear.format(fromDate);
     
     System.out.println("\nfromdate : "+fromDateDay+"-"+fromDateMonth+"-"+fromDateYear);
     System.out.println("\ntodate : "+toDateDay+"-"+toDateMonth+"-"+toDateYear);
	 String[] allFifty={"ACC","ADANIPORTS","AMBUJACEM","ASIANPAINT","AXISBANK","BAJAJ-AUTO","BANKBARODA","BHEL","BPCL","BHARTIARTL","BOSCHLTD","CAIRN","CIPLA","COALINDIA","DRREDDY","GAIL","GRASIM","HCLTECH","HDFCBANK","HEROMOTOCO","HINDALCO","HINDUNILVR","HDFC","ITC","ICICIBANK","IDEA","INDUSINDBK","INFY","KOTAKBANK","LT","LUPIN","MARUTI","NTPC","ONGC","POWERGRID","PNB","RELIANCE","SBIN","SUNPHARMA","TCS","TATAMOTORS","TATAPOWER","TATASTEEL","TECHM","ULTRACEMCO","VEDL","WIPRO","YESBANK","ZEEL"};
	 List<Stock> stockList = new ArrayList<>();
     for(int counter=0;counter<49;counter++)
     {
   	  try {
   		  System.out.println("\n"+allFifty[counter]+":");
   		  //double price;
	          Document doc = Jsoup.connect("http://www.google.com/finance/historical?q=NSE:"+allFifty[counter]+"&startdate="+fromDateMonth+"+"+fromDateDay+"%2C+"+fromDateYear+"&enddate="+toDateMonth+"+"+toDateDay+"%2C+"+toDateYear+"&FORMAT=csv").get();
	          Elements tableElements = doc.select("table[class=gf-table historical_price]");
	
	          Elements tableRowElements = tableElements.select(":not(thead) tr");
	          System.out.println("Date,Open,High,Low,Close,Volume");
	          for (int i = 1; i < tableRowElements.size(); i++) {
	             Element row = tableRowElements.get(i);
	             Elements rowItems = row.select("td");
	             String dateDb=null;
	             try{
	             dateDb=dateSqlFormat.format(date.parse(rowItems.get(0).text().toString()));
	             }
	             catch(ParseException e){
	            	 e.printStackTrace();
	             }
	             double high=Double.parseDouble(rowItems.get(2).text().toString().replaceAll(",",""));
	             double low=Double.parseDouble(rowItems.get(3).text().toString().replaceAll(",",""));
	             //price=Double.parseDouble(rowItems.get(4).text().toString().replaceAll(",",""));
	             Stock stock=new Stock();
	             stock.setSymbol(allFifty[counter]);
	             stock.setDate(dateDb);
	             stock.setHigh(high);
	             stock.setLow(low);
	             stockList.add(stock);
	             }
	          

   	  			} 
   	  			catch (IOException e) {
   	  				e.printStackTrace();
   	  		}
   	  
     	}
     	return stockList;
	 }
}
