(function() {
var MarketCapController = function ($scope, $log, $location, appService) {
	//$scope.username=sessionStorage.getItem("username");
	$scope.companies = [];
    /*$scope.companies=[
	       {"companyname": "Google", "price":25000, "volume":23000 },
		{"companyname": "BHEL", "price":25000, "volume":23000 },
		{"companyname": "Yahoo", "price":25000, "volume":23000 },
		{"companyname": "Infosys", "price":25000, "volume":23000 },
		{"companyname": "Reliance", "price":25000, "volume":23000 },
		{"companyname": "Acc", "price":25000, "volume":23000 },
		{"companyname": "Bajaj motors", "price":25000, "volume":23000 }];
    */
    
    
    $scope.selection = {};
	
    $scope.checkselection = function()
	{
    //$log.log($scope.selection.company.companyName);	
    
    appService.addToPortfolio($scope.selection.company.symbol,$scope.selection.company.price,$scope.quantity,$scope.username).then(function(response) {
		var status = response.data;
		$log.log('Saved the stock in database status '+ status);
		if(status == 1)
        {
			$log.log('TRUE');
            $scope.result = "Saved Successfully";
        }
        else
        {
            $log.log('FALSE');	
            $scope.result = "Oops! Try again";
				
			}
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
        });
     }
	/*console.log($scope.marketCap);*/
   /* appService.displayStocks($scope.username,$scope.marketCap).then(function(response) {
		 angular.forEach(response.data, function(child){
            console.log(child.data);
            
            $scope.companies.push(child.data);
            
            
        });
    });*/
    //  $log.log($scope.selection.company.companyName);
  
    /*-------------------------------------- DISPLAY STOCKS -----------------------------------*/
   appService.displayStocks($scope.username, $scope.marketCap).then(function(response) {
		$scope.companies = response.data;
		//$log.log($scope.companies);
		
		
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
  
       });
       
    /*----------------------------------------ADD TO PORTFOLIO ----------------------------------*/
    /*appService.addToPortfolio($scope.selection.companyName,$scope.price,$scope.quantity,$scope.username).then(function(response) {
		var status = response.data;
		$log.log('Saved the stock in database status '+ status);
		if(status == 1)
        {
			$log.log('TRUE');
            $scope.result = "Saved Successfully";
        }
        else{
            $log.log('FALSE');	
            $scope.result = "Oops! Try again";
				
			}
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
        });*/
  
};
MarketCapController.$inject=['$scope','$log','$location','appService'];	angular.module('myApp').controller('MarketCapController',MarketCapController);

}());