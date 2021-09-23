var app = angular.module("myApp", []);
var ctrl = function($scope){
	$scope.mess = "Anubhav Sharma";
}
app.controller("myCtrl", ctrl);

var login = function(){
	$.post(
		window.location.pathname,
		{
			"userId" : document.getElementById("loginInputId").innerHTML,
			"passWord" : document.getElementById("loginInputPassword").innerHTML
		}
	);
}
