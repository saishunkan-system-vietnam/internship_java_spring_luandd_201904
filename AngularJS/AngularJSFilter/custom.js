var app = angular.module('myApp',[]);
app.controller('myController',function($scope){
	$scope.amount = "1234567";
	$scope.date = new Date();
	$scope.isMe = {
		name : 'Mr.Luan',
		age : 18,
		myColor : 'red'
	};
	$scope.intArray = [1,2,3,4,5,6,7,8];
	$scope.strData = 'ABCDEFGH';
	$scope.number = 123456;
	$scope.arrLimit = 3;
});