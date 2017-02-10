(function() {
var MarketCapController = function ($scope, $log, $location, appService) {
	//$scope.username=sessionStorage.getItem("username");
	$scope.companies = [];



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

    /*-------------------------------------- DISPLAY STOCKS -----------------------------------*/
   appService.displayStocks($scope.username, $scope.marketCap).then(function(response) {
		$scope.companies = response.data;
		//$log.log($scope.companies);


		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);

       });

  

};
MarketCapController.$inject=['$scope','$log','$location','appService'];	angular.module('myApp').controller('MarketCapController',MarketCapController);

}());
