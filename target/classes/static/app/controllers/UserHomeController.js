(function() {
var UserHomeController = function($scope,$stateParams,$log,$location){
    $scope.username = $stateParams.username;
	//$scope.$state = $state;
	
	/*$scope.login = function() {
    //$rootScope.loggedInUser = $scope.username;
		var status;
		status= appService.authenticateUser($scope.username, $scope.password);
		$log.log('Logged in: '+ status);
		if(status === 'true'){
			 $location.path("/userHome/"+$scope.username);
			}else{
				$location.path("/login");
			}
			
   
  };*/
   /* $log.log($scope.params);
    $scope.overview = function(){
        $location.path("/userHome/"+$scope.params + "/overview")
    };*/
};

UserHomeController.$inject=['$scope','$stateParams','$log','$location'];	angular.module('myApp').controller('UserHomeController',UserHomeController);

}());