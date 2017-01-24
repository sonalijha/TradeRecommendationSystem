(function () {
    var appService = function ($http, $log) {
     
        /*var users= [
		   {
			   'username': 'keerthi',
			   'password' : '123'
		   },
		   
		   {
			   'username': 'veeru',
			   'password' : 'abc'
		   },
           
           {
               'username': 'kanika',
               'password': '345'
           }
		   
	   ]; */
    	/*var data = {};
    	this.authenticateUser = function(username,password){
    		$http.post("/login", {data: {
    		      uname : username,
    		      passwrd: password
    		    }} ,
    		    { headers: {"Content-Type": "application/json"}}).success(function(){
    		            alert("Success!");
    		        });
    	};*/
		
         this.authenticateUser = function (username, psswrd) {
        	/*$http.post(' #/login',{data: {
    		      username : username,
    		      password: psswrd
    		    }}).success(function(response)
        			{
        		alert(response.status);
        			})*/
        	/*$http({
        	    method: 'POST',
        	    url: 'http://localhost:8090/#/login',
        	    headers: {
        	        'Content-Type': 'application/json',
        	        'Accept': 'application/json' 
        	    },{username,psswrd      	}).success(function(response)
        			{
        		alert(response.status);
        			}); */
        			/*$http.post('/login', {uname : username, psswrd : psswrd})
        	.success(function(data,status){
        		$log.log(data+' '+ status);
        		if(data == 'true'){
        		$location.path('/home');
        		//return 'true';
        		}else{
        			$location.path('/home');
        		}
        	})
        	.error(function(data,status){
        		//return 'false';
        	})
        	};*/
            /* var len=users.length;
              for (var i=0;i<len;i++) {
               if (users[i].username === username) {
				   if(users[i].password === psswrd){

                   return 'true';
					   }
               }
                  return 'false';
            };*/
        	 return $http.post('http://localhost:7047/login',{
  		      username : username,
		      password: psswrd
		    });

    };
        var marketCap = " ";
        this.setproperty=function(marketCap){
            this.marketCap = marketCap
        }
        
        this.getproperty = function(){
            return this.marketCap;
        }
        this.displayStocks = function(username,marketCap){
            return $http.get('http://localhost:7047/stocks?marketCapType='+ marketCap);
		
        }
        this.addToPortfolio = function(symbol,price,quantity,username){
            
            return $http.post('http://localhost:7047/savestocks',{
              stockList: [{ symbol: symbol, 
                         price : price ,
                         outstandingShares: quantity}],
  		      username : username
		    });
        }
        this.displayPortfolio = function(username){
            return $http.get('http://localhost:7047/portfolio?username='+ username);
        }
        this.displayProfile = function(username){
            return $http.get('http://localhost:7047/profile?username='+ username);
        }
    };
    appService.$inject=['$http','$log'];
    angular.module('myApp').service('appService', appService);
                                           
}());