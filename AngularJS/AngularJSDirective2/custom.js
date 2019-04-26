var app = angular.module("myApp",[]);
app.controller("myCtrl",function($scope){
	$scope.todoDatas = [
		{
			name : 'Dang Luan',
			completed : true
		},{
			name : 'Hoang Nam',
			completed : true
		},{
			name : 'Quoc Dai',
			completed : true
		}
	];

});
app.directive("myTodoList",function(){
	return {
		restrict : 'E',
		templateUrl : 'template.html',
		scope : {
			todoList : '=', // expression
			title : '@' // string
		}
	};
});