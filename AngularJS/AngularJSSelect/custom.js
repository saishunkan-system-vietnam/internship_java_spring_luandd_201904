var myApp = angular.module('myApp',[]);
myApp.controller('myController',function($scope){
	$scope.cars = [
		{ name : 'Honda', color : 'Red'},
		{ name : 'Suzuki', color : 'White'},
		{ name : 'Toyota', color : 'Black'}	
	];
});