var app = angular.module('myApp',[]);
app.directive("helloWorld", function() {
    return {
        restrict : "E",
        template : "<h1>Hello World!</h1>"
    };
});
app.directive("goodBye",function(){
	return {
		restrict : "A",
		template : "<h1>Goodbye</h1>"
	};
});
app.directive("errorMessage",function(){
	return {
		restrict : "C",
		template : "<h1>Error</h1>"
	};
});
app.directive("myComment", function() {
    return {
        restrict : "M",
        replace : true,
        template : "<h1>OK Important!</h1>"
    };
});