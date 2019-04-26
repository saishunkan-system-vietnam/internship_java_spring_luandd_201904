var myApp = angular.module('myApp',[]);
myApp.run(function($rootScope,$interval){
	$rootScope.count = 'Count Down : ';
	// $timeout(function(){
	// 	$rootScope.myname = 'Mr.Luan'
	// },2000)
	$rootScope.number = 10;
	$interval(function(){
		$rootScope.number -= 1;
	},1000)
});