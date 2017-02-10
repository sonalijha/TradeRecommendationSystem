(function() {
var LoginController = function($scope,$location,$log,$window,$http,appService){



	$scope.login = function() {

		var status;
		appService.authenticateUser($scope.username, $scope.password).then(function(response) {
		status= response.data;
		$log.log('Logged in: '+ status);
		if(status == 1){
			$log.log('TRUE');
			 $location.path('/userHome/'  + $scope.username);
			}
        else{
               $log.log('FALSE');
                $location.path("/login");
                $scope.result = "Invalid Credentials";
			}
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
        });
       

  };
};

LoginController.$inject=['$scope','$location','$log','$window','$http','appService'];	angular.module('myApp').controller('LoginController',LoginController);

}());
