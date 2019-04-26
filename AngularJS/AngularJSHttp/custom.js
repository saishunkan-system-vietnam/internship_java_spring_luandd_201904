var myApp = angular.module('myApp',[]);
myApp.run(function($rootScope,$http){
	$http({
		method : 'GET',
		url : 'https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452'
	}).then(function(response){
		$rootScope.dataResponse = response.data;
	},function(error){
		$rootScope.dataResponse = response.statusText;
	});
});