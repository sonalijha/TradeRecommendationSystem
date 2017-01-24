(function() {
var PortfolioController = function($scope,$location,$log,$http,appService){
$log.log($scope.username);
$scope.portfolio = [];
 appService.displayPortfolio($scope.username).then(function(response) {
		$scope.portfolio = response.data;
		//$log.log($scope.companies);
		$log.log($scope.portfolio);
			
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
 
 });
};
PortfolioController.$inject=['$scope','$location','$log','$http','appService'];	
angular.module('myApp').controller('PortfolioController',PortfolioController);

}());