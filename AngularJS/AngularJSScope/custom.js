var myApp = angular.module('myApp',[]);
myApp.run(function($rootScope){
	$rootScope.color = 'Blue';
});
myApp.controller('myController',function($scope,$location){
	$scope.color = 'Red';
	$scope.myUrls = $location.absUrl();
});