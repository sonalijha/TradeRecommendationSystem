(function() {
var MarketCapController = function($scope,$log,$location,appService,marketCapService,$http){
	//$scope.username=sessionStorage.getItem("username");
	$scope.stocks = [];
	/*$scope.login = function() {
    //$rootScope.loggedInUser = $scope.username;
		var status;
		status= appSer, "volume":vice.authenticateUser($scope.username, $scope.password);
		$log.log('Logged in: '+ status);
		if(status === 'true'){
			 $location.path("/userHome/"+$scope.username);
			}else{
				$location.path("/login");
			}


  };*/
	/*$scope.load = function()
	{
		 $http.post(' http://localhost:8090/marketCap',{data: {
			marketcap:$scope.marketcap
		}}).then(function (response){
			$scope.companies=response.companies;
		});
};*/
	console.log($scope.marketCap);
    marketCapService.displayStocks($scope.username,$scope.marketCap).then(function(response) {
		 angular.forEach(response.data, function(child){
            console.log(child.data);
            
            $scope.stocks.push(child.data);
            
            
        });
    });
		/*$log.log('Logged in: '+ status);
		if(status == 1){
			$log.log('TRUE');
			 $location.path('/userHome/'+':' + $scope.username);
			}else{
				$log.log('FALSE');	
				//$location.path('/userHome/'+$scope.username);
				$location.path("/login");
				 //$location.path('/userHome/'+':' + $scope.username);
			}
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
        })*/
    /*$scope.addToWatchlist =function ()
    {
        $http.post(' http://localhost:8090/watchList',{data: {
        companies:$scope.comapanies}})
    }*/
};
MarketCapController.$inject=['$scope','$log','$location','appService','marketCapService','$http'];	angular.module('myApp').controller('MarketCapController',MarketCapController);

}());