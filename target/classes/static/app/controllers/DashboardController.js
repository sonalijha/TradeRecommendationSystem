(function() {
var DashboardController = function($scope,$log,$location,appService,$http){
	//$scope.username=sessionStorage.getItem("username");
	
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
    /*$scope.addToWatchlist =function ()
    {
        $http.post(' http://localhost:8090/watchList',{data: {
        companies:$scope.comapanies}})
    }*/
    $scope.load = function(){
        $location.path("userHome/" + $scope.username + "/dashboard/marketCap/" + $scope.marketCap);
       
    };
    
    appService.setproperty($scope.marketCap);
   /* $scope.companies=[];
     appService.displayStocks($scope.username, $scope.marketCap).then(function(response) {
		$scope.companies = response.data;
		$log.log($scope.companies);
		
			
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
        });*/
  
};
DashboardController.$inject=['$scope','$log','$location','appService','$http'];	angular.module('myApp').controller('DashboardController',DashboardController);

}());
