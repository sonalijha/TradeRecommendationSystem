//option 1
//var app = angular.module('customerApp',[]);

//option 2
(function(){
	var app= angular.module('myApp',['ui.router']);
	
	app.config(function($stateProvider,$urlRouterProvider) {
        $urlRouterProvider.when('/userHome/:username','userHome/:username/dashboard');
        $urlRouterProvider.otherwise('/login');
        
        $stateProvider
            .state('login', {
          url: '/login',
          templateUrl: 'app/views/login.html',
          controller: 'LoginController'
        })
        .state('userHome', {
   url: '/userHome/:username',   
    templateUrl: 'app/views/userHome.html',
   controller: 'UserHomeController',
   resolve:{
      username: ['$stateParams', function($stateParams){
          return $stateParams.username;
      }]
   }
})
               .state('userHome.dashboard', {
            url: '/dashboard', 
            templateUrl: 'app/views/dashboard.html',
            controller: 'DashboardController'
  
})
        .state('userHome.dashboard.marketCap', {
            url: '/marketCap/:marketCap', 
            templateUrl: 'app/views/marketCap.html',
            controller: 'MarketCapController',
             resolve:{
      marketCap: ['$stateParams', function($stateParams){
          return $stateParams.marketCap;
      }]
   }
  
})
       
            
            .state('userHome.profile', {
   url: '/profile', 
            templateUrl: 'app/views/profile.html',
            controller: 'ProfileController'
  
})
        .state('userHome.portfolio', {
            url: '/portfolio', 
            templateUrl: 'app/views/portfolio.html',
            controller: 'PortfolioController'
  
})
        .state('userHome.watchlist', {
   url: '/watchlist', 
            templateUrl: 'app/views/watchlist.html',
            controller: 'WatchlistController'
  
});
        
        
    })
   /* .factory('ClockSrv', function($interval){
  var clock = null;
  var service = {
    startClock: function(fn){
      if(clock === null){
        clock = $interval(fn, 60000);
      }
    },
    stopClock: function(){
      if(clock !== null){
        $interval.cancel(clock);
        clock = null;
      }
    }
  };

  return service;
})
    .run(function($http,ClockSrv){
  ClockSrv.startClock(function(){
$http.get('http://192.168.0.106:7057/updatehistoricaldata');
  });
})*/
    ;
}());
 