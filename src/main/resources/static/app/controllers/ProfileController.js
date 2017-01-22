(function() {
var ProfileController = function($scope,$location,$log,$http,appService){
    
    appService.displayProfile($scope.username).then(function(response) {
		$scope.profiledetails = response.data;
		//$log.log($scope.companies);
		$log.log($scope.profiledetails);
			
		}, function(data, status, headers, config) {
            $log.log(data.error + ' ' + status);
 
 });
};
ProfileController.$inject=['$scope','$location','$log','$http','appService'];
angular.module('myApp').controller('ProfileController',ProfileController);
}());
