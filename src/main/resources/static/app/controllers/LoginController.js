(function() {
var LoginController = function($scope,$location,$log,$window,$http,appService){
	/*$scope.sortBy='name';
	$scope.reverse= false;
	
	$scope.people=[{name:'keerthi', city:'Pune', dob:'1992-06-26', amount:'1234.56'},{name:'veeru', city:'Hyd',dob:'1993-10-07', amount:'9234'},{name:'sanju', city:'Mbnr', dob:'1994-06-26', amount:'1234.00'}] ;
	
	$scope.doSort =  function(propName){
		$scope.sortBy=propName;
		$scope.reverse= !$scope.reverse;
	};*/
     
    
	$scope.login = function() {
    //$rootScope.loggedInUser = $scope.username;
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
       /* var status;
		status= appService.authenticateUser($scope.username, $scope.password);
		$log.log('Logged in: '+ status);
		if(status === 'true'){
			 $location.path("/userHome/"+$scope.username);
			}else{
				$location.path("/login");
			}*/
			
   
  };
};

LoginController.$inject=['$scope','$location','$log','$window','$http','appService'];	angular.module('myApp').controller('LoginController',LoginController);

}());