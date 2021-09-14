var app = angular.module("myApp", []);
var ctrl = function($scope){
	$scope.mess = "Anubhav Sharma";
}
app.controller("myCtrl", ctrl);
