package com.stockmarket.stock;

public class StockData {/*
	public static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText.substring(6));
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	public  List<Stock> fetchStockData() throws JSONException, IOException{
		List<Stock> listOfStocks=new ArrayList<Stock>();
		  
		  String[] allFifty={"ACC","ADANIPORTS","AMBUJACEM","ASIANPAINT","AXISBANK","BAJAJ-AUTO","BANKBARODA","BHEL","BPCL","BHARTIARTL","BOSCHLTD","CAIRN","CIPLA","COALINDIA","DRREDDY","GAIL","GRASIM","HCLTECH","HDFCBANK","HEROMOTOCO","HINDALCO","HINDUNILVR","HDFC","ITC","ICICIBANK","IDEA","INDUSINDBK","INFY","KOTAKBANK","LT","LUPIN","MARUTI","NTPC","ONGC","POWERGRID","PNB","RELIANCE","SBIN","SUNPHARMA","TCS","TATAMOTORS","TATAPOWER","TATASTEEL","TECHM","ULTRACEMCO","VEDL","WIPRO","YESBANK","ZEEL"};
		  System.out.println("Current stock quotes : ");
		  
	      for(int i=0;i<49;i++)
		  {
	    	  Stock stock=new Stock();
	    	  try{
	    	  JSONObject json = readJsonFromUrl("http://finance.google.com/finance/info?infotype=infoquoteall&q=NSE:"+allFifty[i]);
	    	  //System.out.println(json.toString());
	    	  stock.setCompanyName((String)json.get("name"));
	    	  double price=Double.parseDouble(json.getString("l"));
	    	  stock.setPrice(price);
	    	  String shares=(String)json.get("shares");
	    	  double cp_fix=Double.parseDouble(json.getString("cp_fix"));
	    	  char illion=shares.charAt(shares.length()-1);
	    	  double oShares=Double.parseDouble(shares.substring(0,shares.length()-1));
	    	  String markCapType=null;
	    	  long markCap;
	    	  long outstandingShares;
	    	  if(illion=='M'){
	    		  outstandingShares=(long)oShares*1000000;
	    	  }
	    	  else
	    		  outstandingShares=((long)oShares*1000000000);
	    	  Double d=(price*outstandingShares);
	    	  markCap=d.longValue();
	    	  if(markCap>=10000000000L)
	    		  markCapType="Large";
	    	  else if(markCap<=10000000000L && markCap>=2000000000)
	    		  markCapType="Mid";
	    	  else if(markCap<=2000000000 && markCap>=300000000)
	    		  markCapType="Small";
	    	  stock.setMarketCapitalization(markCap);
	    	  stock.setMarketCapType(markCapType);
	    	  //parse price and convert to long as well then calculate marketcap i.e. outstandingshares*price, based on this set the value of the variable marketcaptype
	    	  }
	    	  
	      finally{
			  
		  }
	    	  listOfStocks.add(stock);
	   }
	  	return listOfStocks;
  
	}

*/}
