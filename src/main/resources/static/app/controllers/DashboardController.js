(function() {
var DashboardController = function($scope,$log,$location,appService,$http){

    $scope.load = function(){
        $location.path("userHome/" + $scope.username + "/dashboard/marketCap/" + $scope.marketCap);

    };

    appService.setproperty($scope.marketCap);
};
DashboardController.$inject=['$scope','$log','$location','appService','$http'];	angular.module('myApp').controller('DashboardController',DashboardController);

}());
