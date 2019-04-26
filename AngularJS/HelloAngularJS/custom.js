// created app mapping myapp
var app = angular.module('myApp',[]);
// Make many controller
app.controller('myController',function($scope){
	$scope.operator = '+';
	$scope.var1 = 30;
	$scope.var2 = 20;
	$scope.calcSum = function(){
		$scope.operator = '+';
	};
	$scope.caclSub = function(){
		$scope.operator = '-';
	}
	$scope.calculate = function(){
		if($scope.operator == "+"){
			$scope.result = parseFloat($scope.var1) + parseFloat($scope.var2);
		}else if($scope.operator == "-"){
			$scope.result = parseFloat($scope.var1) - parseFloat($scope.var2);
		}
	};
});