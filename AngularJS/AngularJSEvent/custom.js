var myApp = angular.module('myApp',[]);
myApp.controller('myCtr',function($scope){
	$scope.overCount = 0;
	$scope.enterCount = 0;
	$scope.moveCount = 0;
	$scope.leaveCount = 0;
	$scope.upCount = 0;
	$scope.downCount = 0;
	$scope.clickCount = 0;

	$scope.mouseoverHandler = function($event){
		$scope.overCount += 1;
	};

	$scope.mouseenterHandler = function($event){
		$scope.enterCount += 1;
	};
	$scope.mousemoveHandler = function($event){
		$scope.moveCount += 1;
	}
	$scope.mouseleaveHandler = function($event){
		$scope.leaveCount += 1;
	}

	$scope.mouseupHandler = function($event){
		$scope.upCount += 1;
	}
	$scope.mousedownHandler = function($event){
		$scope.downCount += 1;
	}
	$scope.mouseclickHandler = function($event){
		$scope.clickCount += 1;
	}
});