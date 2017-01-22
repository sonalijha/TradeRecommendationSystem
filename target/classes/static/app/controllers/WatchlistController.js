(function() {
var WatchlistController = function($scope,$location,$log,$http,appService){
   $scope.myWatchlist=[
		{"companyname": "Google", "price":25000, "volume":23000 },
		{"companyname": "Google", "price":25000, "volume":23000 },
		{"companyname": "Yahoo", "price":25000, "volume":23000 },
		{"companyname": "Google", "price":25000, "volume":23000 }, 
 ]
 /*$http.get("#").then(function (response) {        //(provide the url here)
      $scope.myWatchlist = response.data.watchlistdata;         //watchlist data array of customers 
  });
*/
};
WatchlistController.$inject=['$scope','$location','$log','$http','appService'];
angular.module('myApp').controller('WatchlistController',WatchlistController);
}());
